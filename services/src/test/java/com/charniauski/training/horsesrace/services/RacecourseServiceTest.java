package com.charniauski.training.horsesrace.services;

import com.charniauski.training.horsesrace.daodb.RacecourseDao;
import com.charniauski.training.horsesrace.datamodel.Racecourse;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
public class RacecourseServiceTest {

    @Inject
    private RacecourseService racecourseService;

    @Inject
    private RacecourseDao racecourseDao;

    private Racecourse testRacecourse;

    private Long testRacecourseId;

    @BeforeClass
    public static void prepareTestData() {

    }

    @AfterClass
    public static void deleteTestData() {
//        System.out.println("deleteTestData");
    }

    @Before
    public void prepareMethodData() {
        testRacecourse = new Racecourse();
        testRacecourse.setName("TEST");
        testRacecourse.setCountry("FRA");
        testRacecourseId = racecourseDao.insert(testRacecourse);
    }

    @After
    public void deleteMethodData() {
        racecourseDao.delete(testRacecourseId);
        testRacecourseId = null;
    }


    @Test
    public void getByIdTest() {
        Racecourse racecourse = racecourseDao.get(testRacecourseId);
        testRacecourse.setId(testRacecourseId);
        assertNotNull(racecourse);
        assertEquals(testRacecourseId, racecourse.getId());
    }

    @Test
    public void saveInsertTest() {
        Long id = testRacecourse.getId();
        Racecourse racecourse1 = racecourseDao.get(id);
        assertNull(racecourse1);
        if (testRacecourse.getId() == null) {
            testRacecourse.setName("TEST1");
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
        assertNotNull(testRacecourseId);
        testRacecourse.setId(testRacecourseId);
        if (testRacecourse.getId() == null) {
            testRacecourseId = racecourseDao.insert(testRacecourse);
        } else {
            racecourseDao.update(testRacecourse);
        }
        Racecourse racecourse = racecourseDao.get(testRacecourseId);
        assertEquals(testRacecourse, racecourse);
    }

    @Test
    public void deleteTest() {
        testRacecourse.setName("TEST1");
        Long id = racecourseDao.insert(testRacecourse);
        boolean delete = racecourseDao.delete(id);
        assertTrue(delete);
    }

    @Test
    public void saveAllTest() {
        Racecourse testRacecourse1 = new Racecourse();
        testRacecourse1.setName("TEST1");
        testRacecourse1.setCountry("FRA");
        List<Racecourse> arrayList = new ArrayList<>();
        testRacecourse.setName("TEST2");
        arrayList.addAll(Arrays.asList(testRacecourse, testRacecourse1));
        System.out.println(arrayList);
        racecourseService.saveAll(arrayList);
        Racecourse racecourse = racecourseDao.getRacecourseByName("TEST2");
        Racecourse racecourse1 = racecourseDao.getRacecourseByName("TEST1");
        testRacecourse.setId(racecourse.getId());
        testRacecourse1.setId(racecourse1.getId());
        assertEquals(testRacecourse, racecourse);
        assertEquals(testRacecourse1, racecourse1);
        racecourseDao.delete(racecourse1.getId());
        racecourseDao.delete(racecourse.getId());
    }

    @Test
    public void getAll() {
        List<Racecourse> all = racecourseDao.getAll();
        assertNotNull(all);
        assertNotNull(all.get(0).getId());
    }

    @Test
    public void getRacecourseByLogin(){
        Racecourse testLoginNew = racecourseDao.getRacecourseByName("TEST");
        testRacecourse.setId(testRacecourseId);
        assertEquals(testRacecourse,testLoginNew);
    }

}
