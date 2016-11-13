package com.charniauski.training.horsesrace.services;


import com.charniauski.training.horsesrace.daoapi.RacecourseDao;
import com.charniauski.training.horsesrace.datamodel.RaceCard;
import com.charniauski.training.horsesrace.datamodel.Racecourse;
import com.charniauski.training.horsesrace.services.exception.NoSuchEntityException;
import com.charniauski.training.horsesrace.services.testutil.BaseCreator;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.*;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
public class RacecourseServiceTest {

    @Inject
    private RacecourseService racecourseService;

    private Racecourse testRacecourse;

    @BeforeClass
    public static void prepareTestData() {
        ClassPathXmlApplicationContext springContext = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        springContext.getBean(BaseCreator.class).createRelationDB();
    }

    @Inject
    private RaceCardService raceCardService;

    private Long testRacecourseId;


    @AfterClass
    public static void deleteTestData() {

    }

    @Before
    public void prepareMethodData() {
        ClassPathXmlApplicationContext springContext = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        springContext.getBean(BaseCreator.class).createXMLDB();
        testRacecourse = new Racecourse();
        testRacecourse.setName("TEST");
        testRacecourse.setCountry("FRA");
        testRacecourseId = 1L;
//        testRacecourseId = racecourseDao.insert(testRacecourse);
    }

    @After
    public void deleteMethodData() {
//        racecourseDao.delete(testRacecourseId);
        testRacecourse = null;
        testRacecourseId = null;
    }


    @Test
    public void getByIdTest() {
        Racecourse racecourse = racecourseService.get(1L);
        testRacecourse.setId(testRacecourseId);
        assertNotNull(racecourse);
        assertEquals(testRacecourseId, racecourse.getId());
    }

    @Test
    public void saveInsertTest() {
        Long id =racecourseService.save(testRacecourse);
        Racecourse racecourse = racecourseService.get(id);
        assertNotNull(racecourse);
        testRacecourse.setId(id);
        assertEquals(testRacecourse, racecourse);
        testRacecourse.setId(id);
        racecourseService.delete(testRacecourse);
    }

    @Test
    public void saveUpdateTest() {
        Racecourse racecourse1 = racecourseService.get(1L);
        racecourse1.setId(null);
        racecourse1.setName("test2");
        Long id = racecourseService.save(racecourse1);
            racecourseService.save(racecourse1);
        racecourse1.setId(id);
        Racecourse racecourse = racecourseService.get(id);
        assertEquals(racecourse1, racecourse);
    }

    @Test
    public void deleteTest() {
        testRacecourse.setName("TEST1");
        Long id = racecourseService.save(testRacecourse);
        testRacecourse.setId(id);
        boolean delete = racecourseService.delete(testRacecourse);
        assertTrue(delete);
    }

    @Test
    public void saveAllTest() throws NoSuchEntityException {
        Racecourse testRacecourse1 = new Racecourse();
        testRacecourse1.setName("TEST1");
        testRacecourse1.setCountry("FRA");
        List<Racecourse> arrayList = new ArrayList<>();
        testRacecourse.setName("TEST2");
        arrayList.addAll(Arrays.asList(testRacecourse, testRacecourse1));
        racecourseService.saveAll(arrayList);
        Racecourse racecourse = racecourseService.getByName("TEST2");
        Racecourse racecourse1 = racecourseService.getByName("TEST1");
        testRacecourse.setId(racecourse.getId());
        testRacecourse1.setId(racecourse1.getId());
        assertEquals(testRacecourse, racecourse);
        assertEquals(testRacecourse1, racecourse1);
        racecourseService.delete(racecourse1);
        racecourseService.delete(racecourse);
    }

    @Test
    public void getAllTest() {
        List<Racecourse> all = racecourseService.getAll();
        assertNotNull(all);
        assertNotNull(all.get(0).getId());
    }

    @Test
    public void getRacecourseByNameTest() {
        Racecourse racecourse = racecourseService.getByName("germ");
        assertEquals("germ", racecourse.getName());
    }

    @Test
    public void getAllAfterCurrentDateTest() {
        Date date = new Date();
        List<Racecourse> racecourses = racecourseService.getAllAfterCurrentDate();
        Set<RaceCard> raceCards=new HashSet<>();
        List<RaceCard> list;
        for (Racecourse racecourse:racecourses) {
            list = raceCardService.getAllByRacecourseAfterCurrentDate(racecourse.getId());
            System.out.println(list);
            if (list.isEmpty())continue;
            for (RaceCard raceCard:list) {
                raceCards.add(raceCard);
                break;
            }
        }
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.add(Calendar.HOUR, 24);
        for (RaceCard raceCard:raceCards) {
            assertTrue(raceCard.getDateStart().after(date));
            assertTrue(raceCard.getDateStart().before(instance.getTime()));
        }
    }

//
//    RacecourseWrapper getRacecourseWrapper(Long racecourseId);

}
