package com.charniauski.training.horsesrace.services;


import com.charniauski.training.horsesrace.daoapi.RaceCardDao;
import com.charniauski.training.horsesrace.datamodel.RaceCard;
import com.charniauski.training.horsesrace.services.exception.NoSuchEntityException;
import com.charniauski.training.horsesrace.services.testutil.BaseCreator;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.util.*;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
public class RaceCardServiceTest {


    @Inject
    private RaceCardService raceCardService;

    private RaceCard testRaceCard;

    private Long testRaceCardId;

    @BeforeClass
    public static void prepareTestData() {
        ClassPathXmlApplicationContext springContext = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        springContext.getBean(BaseCreator.class).createRelationDB();
    }

    @AfterClass
    public static void deleteTestData() {
//        System.out.println("deleteTestData");
    }

    @Before
    public void prepareMethodData() {
        ClassPathXmlApplicationContext springContext = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        springContext.getBean(BaseCreator.class).createXMLDB();
        testRaceCard = new RaceCard();
        testRaceCard.setRacecourseId(1L);
        testRaceCard.setRaceType("Type");
        testRaceCard.setDateStart(new Timestamp(new Date().getTime()));
        testRaceCardId = 1L;
    }

    @After
    public void deleteMethodData() {
        testRaceCard = null;
        testRaceCardId = null;
    }


    @Test
    public void getByIdTest() {
        testRaceCard.setId(testRaceCardId);
        RaceCard raceCard = raceCardService.get(testRaceCard.getId());
        assertNotNull(raceCard);
        assertEquals(testRaceCard.getId(), raceCard.getId());
    }

    @Test
    public void saveInsertTest() {
        Long id = null;
            id = raceCardService.save(testRaceCard);
        RaceCard raceCard = raceCardService.get(id);
        assertNotNull(raceCard);
        testRaceCard.setDateStart(new Date(testRaceCard.getDateStart().getTime()));
        testRaceCard.setId(id);
        assertEquals(testRaceCard, raceCard);
        raceCardService.delete(testRaceCard);
    }

    @Test
    public void saveUpdateTest() {
        assertNotNull(testRaceCardId);
        testRaceCard.setId(testRaceCardId);
            raceCardService.save(testRaceCard);
        RaceCard raceCard = raceCardService.get(testRaceCardId);
        testRaceCard.setDateStart(new Date(testRaceCard.getDateStart().getTime()));
        assertEquals(testRaceCard, raceCard);
    }

    @Test
    public void deleteTest() {
        Long id = raceCardService.save(testRaceCard);
        testRaceCard.setId(id);
        boolean delete = raceCardService.delete(testRaceCard);
        assertTrue(delete);
    }

    @Test
    public void saveAllTest() throws NoSuchEntityException {
        RaceCard testRaceCard1 = new RaceCard();
        testRaceCard1.setRaceType("Type");
        testRaceCard1.setDateStart(new Timestamp(new Date().getTime()));
        testRaceCard1.setRacecourseId(1L);
        List<RaceCard> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(testRaceCard, testRaceCard1));
        raceCardService.saveAll(arrayList);
        List<RaceCard> list = raceCardService.getAll();
        testRaceCard.setId(list.get(5).getId());
        testRaceCard1.setId(list.get(6).getId());
        testRaceCard.setDateStart(new Date(testRaceCard.getDateStart().getTime()));
        testRaceCard1.setDateStart(new Date(testRaceCard1.getDateStart().getTime()));
        assertEquals(testRaceCard, list.get(5));
        assertEquals(testRaceCard1, list.get(6));
        raceCardService.delete(list.get(5));
        raceCardService.delete(list.get(6));
    }

    @Test
    public void getAllTest() {
        List<RaceCard> all = raceCardService.getAll();
        assertNotNull(all);
        assertNotNull(all.get(0).getId());
    }

    @Test
    public void getAllByRacecourseAfterCurrentDateTest() {
        Date date = new Date();
        List<RaceCard> raceCards = raceCardService.getAllByRacecourseAfterCurrentDate(1L);
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.add(Calendar.HOUR,24);
        for (RaceCard raceCard : raceCards) {
            assertEquals(new Long(1L), raceCard.getRacecourseId());
            assertTrue(raceCard.getDateStart().after(date));
            assertTrue(raceCard.getDateStart().before(instance.getTime()));
        }
    }

    @Test
    public void getThreeNextAfterCurrentDateTest() {
        Date date = new Date();
        List<RaceCard> raceCards = raceCardService.getThreeNextAfterCurrentDate(1L);
        System.out.println(raceCards);
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.add(Calendar.HOUR,24);
        for (RaceCard raceCard : raceCards) {
            assertEquals(new Long(1L), raceCard.getRacecourseId());
            assertTrue(raceCard.getDateStart().after(date));
            assertTrue(raceCard.getDateStart().before(instance.getTime()));
        }
        System.out.println(raceCards.size());
        assertTrue(raceCards.size() < 4);
    }

    @Test
    public void getDateStartByEventTest() {
        RaceCard raceCard = raceCardService.get(1L);
        Date date = raceCardService.getDateStartByEvent(4L);
        assertNotNull(date);
        assertEquals(raceCard.getDateStart(),date);

    }

    @Test
    public void saveDateFinishTest(){
        RaceCard raceCard=raceCardService.get(2L);
        Timestamp timestamp = new Timestamp(new Date().getTime());
        raceCard.setDateFinish(timestamp);
        raceCardService.saveDateFinish(2L,timestamp);
        raceCard.setDateFinish(new Date(raceCard.getDateFinish().getTime()));
        RaceCard raceCard1 = raceCardService.get(2L);
        assertEquals(raceCard, raceCard1);
    }

//    @Test
//    public void getRaceCardWrapperTest(){
//        RaceCardWrapper raceCardWrapper=new RaceCardWrapper();
//        RaceCard raceCard=raceCardService.get(1L);
//        raceCardWrapper.setRacecourse(racecourseService.get(raceCard.getRacecourseId()));
//        raceCardWrapper.setRaceCard(raceCard);
//        List<RaceDetail> raceDetails=raceDetailService.getByRaceCard(raceCard.getId());
//        List<RaceDetailWrapper> raceDetailWrappers=new ArrayList<>();
//        for (RaceDetail raceDetail:raceDetails) {
//            raceDetailWrappers.add(raceDetailService.getRaceDetailWrapper(raceDetail.getId()));
//        }
//        raceCardWrapper.setRaceDetailWrappers(raceDetailWrappers);
//        RaceCardWrapper raceCardWrapper1 = raceCardService.getRaceCardWrapper(1L);
//        assertNotNull(raceCardWrapper1);
//        assertEquals(raceCardWrapper,raceCardWrapper1);
//    }
}
