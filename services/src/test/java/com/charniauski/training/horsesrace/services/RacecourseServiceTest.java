package com.charniauski.training.horsesrace.services;

import com.charniauski.training.horsesrace.daodb.RacecourseDao;
import com.charniauski.training.horsesrace.datamodel.RaceCard;
import com.charniauski.training.horsesrace.datamodel.Racecourse;
import com.charniauski.training.horsesrace.services.exception.NoSuchEntityException;
import com.charniauski.training.horsesrace.services.testUtil.CreateBase;
import org.junit.*;
import org.junit.runner.RunWith;
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

    @Inject
    private RacecourseDao racecourseDao;

    private Racecourse testRacecourse;

    @Inject
    private RaceCardService raceCardService;

    private Long testRacecourseId;

    @BeforeClass
    public static void prepareTestData() {
        new CreateBase().init();
    }

    @AfterClass
    public static void deleteTestData() {

    }

    @Before
    public void prepareMethodData() {
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
        Racecourse racecourse = racecourseDao.get(1L);
        testRacecourse.setId(testRacecourseId);
        assertNotNull(racecourse);
        assertEquals(testRacecourseId, racecourse.getId());
    }

    @Test
    public void saveInsertTest() {
        Long id = null;
        if (testRacecourse.getId() == null) {
            id = racecourseDao.insert(testRacecourse);
        } else {
            racecourseDao.update(testRacecourse);
        }
        Racecourse racecourse = racecourseDao.get(id);
        assertNotNull(racecourse);
        testRacecourse.setId(id);
        assertEquals(testRacecourse, racecourse);
        racecourseDao.delete(id);
    }

    @Test
    public void saveUpdateTest() {
        Racecourse racecourse1 = racecourseDao.get(1L);
        racecourse1.setId(null);
        racecourse1.setName("test2");
        Long id = racecourseDao.insert(racecourse1);
        if (racecourse1.getId() == null) {
        } else {
            racecourseDao.update(racecourse1);
        }
        racecourse1.setId(id);
        Racecourse racecourse = racecourseDao.get(id);
        assertEquals(racecourse1, racecourse);
    }

    @Test
    public void deleteTest() {
        testRacecourse.setName("TEST1");
        Long id = racecourseDao.insert(testRacecourse);
        boolean delete = racecourseDao.delete(id);
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
        Racecourse racecourse = racecourseDao.getByName("TEST2");
        Racecourse racecourse1 = racecourseDao.getByName("TEST1");
        testRacecourse.setId(racecourse.getId());
        testRacecourse1.setId(racecourse1.getId());
        assertEquals(testRacecourse, racecourse);
        assertEquals(testRacecourse1, racecourse1);
        racecourseDao.delete(racecourse1.getId());
        racecourseDao.delete(racecourse.getId());
    }

    @Test
    public void getAllTest() {
        List<Racecourse> all = racecourseDao.getAll();
        assertNotNull(all);
        assertNotNull(all.get(0).getId());
    }

    @Test
    public void getRacecourseByNameTest() {
        Racecourse racecourse = racecourseDao.getByName("germ");
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
