package com.charniauski.training.horsesrace.services;


import com.charniauski.training.horsesrace.datamodel.RaceCard;
import com.charniauski.training.horsesrace.datamodel.RaceDetail;
import com.charniauski.training.horsesrace.services.exception.NoSuchEntityException;
import com.charniauski.training.horsesrace.services.testutil.BaseCreator;
import com.charniauski.training.horsesrace.services.wrapper.RaceCardWrapper;
import com.charniauski.training.horsesrace.services.wrapper.RaceDetailWrapper;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.util.*;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
@TestExecutionListeners(listeners = {DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class, TransactionalTestExecutionListener.class})
public class RaceCardServiceTest {


    @Inject
    private RaceCardService raceCardService;
    @Inject
    private BaseCreator baseCreator;
    @Inject
    private RaceDetailService raceDetailService;
    @Inject
    private RacecourseService racecourseService;

    private RaceCard testRaceCard;

    private Long testRaceCardId;

    @Parameterized.Parameters
    public static void getBaseCreator(BaseCreator baseCreator){
//        baseCreator.createRelationDB();
    }
    @BeforeClass
    public static void prepareTestData() {
        ClassPathXmlApplicationContext springContext = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        BaseCreator baseCreator1 = (BaseCreator) springContext.getBean("baseCreator");
        baseCreator1.createRelationDB();
        baseCreator1.createXMLDB();
    }

    @AfterClass
    public static void deleteTestData() {
//        System.out.println("deleteTestData");
    }

    @Before
    public void prepareMethodData() {
       baseCreator.createXMLDB();
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
        Long id =raceCardService.save(testRaceCard);
        RaceCard raceCard = raceCardService.get(id);
        assertNotNull(raceCard);
        testRaceCard.setDateStart(new Date(testRaceCard.getDateStart().getTime()));
        testRaceCard.setId(id);
        assertEquals(testRaceCard, raceCard);
        raceCardService.delete(testRaceCard.getId());
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
        boolean delete = raceCardService.delete(testRaceCard.getId());
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
        raceCardService.delete(list.get(5).getId());
        raceCardService.delete(list.get(6).getId());
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
        instance.add(Calendar.HOUR, 24);
        for (RaceCard raceCard : raceCards) {
            assertEquals(new Long(1L), raceCard.getRacecourseId());
            assertTrue(raceCard.getDateStart().after(date));
            assertTrue(raceCard.getDateStart().before(instance.getTime()));
        }
    }


    @Test
    public void getDateStartByEventTest() {
        RaceCard raceCard = raceCardService.get(2L);
        Date date = raceCardService.getDateStartByEvent(3L);
        assertNotNull(date);
        assertEquals(raceCard.getDateStart(), date);

    }


    @Test
    public void getRaceCardWrapperTest(){
        RaceCardWrapper raceCardWrapper=new RaceCardWrapper();
        RaceCard raceCard=raceCardService.get(2L);
        System.out.println(raceCard);
        raceCardWrapper.setRacecourse(racecourseService.get(raceCard.getRacecourseId()));
        raceCardWrapper.setRaceCard(raceCard);
        List<RaceDetail> raceDetails=raceDetailService.getAllByRaceCard(raceCard.getId());
        List<RaceDetailWrapper> raceDetailWrappers=new ArrayList<>();
        for (RaceDetail raceDetail:raceDetails) {
            raceDetailWrappers.add(raceDetailService.getAllDataForRaceDetail(raceDetail.getId()));
        }
        raceCardWrapper.setRaceDetailWrappers(raceDetailWrappers);
        RaceCardWrapper raceCardWrapper1 = raceCardService.getAllDataForRaceCard(2L);
        assertNotNull(raceCardWrapper1);
        assertEquals(raceCardWrapper,raceCardWrapper1);
    }
}
