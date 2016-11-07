package com.charniauski.training.horsesrace.services;

import com.charniauski.training.horsesrace.daodb.HorseDao;
import com.charniauski.training.horsesrace.datamodel.Horse;
import com.charniauski.training.horsesrace.services.exception.NoSuchEntityException;
import com.charniauski.training.horsesrace.services.testUtil.CreateBase;
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
public class HorseServiceTest {

    @Inject
    private HorseService horseService;

    @Inject
    private HorseDao horseDao;

    private Horse testHorse;

    private Long testHorseId;

    @BeforeClass
    public static void prepareTestData() {
        new CreateBase().init();
    }

    @AfterClass
    public static void deleteTestData() {
//        System.out.println("deleteTestData");
    }

    @Before
    public void prepareMethodData() {
        testHorse = new Horse();
        testHorse.setNickName("TestNickName");
        testHorse.setAge(3);
        testHorse.setEquipmentWeight(60);
        testHorse.setForm("TestForm");
        testHorse.setOwner("TestOwner");
        testHorseId=3L;
    }

    @After
    public void deleteMethodData() {
        testHorse=null;
        testHorseId = null;
    }


    @Test
    public void getByIdTest() {
        testHorse.setId(testHorseId);
        Horse horse = horseDao.get(testHorse.getId());
        assertNotNull(horse);
        assertEquals(testHorse.getId(), horse.getId());
    }

    @Test
    public void saveInsertTest() {
        Long id = null;
        if (testHorse.getId() == null) {
            testHorse.setNickName("TestNickName1");
            id = horseDao.insert(testHorse);
        } else {
        }
        Horse horse = horseDao.get(id);
        assertNotNull(horse);
        testHorse.setId(id);
        assertEquals(testHorse, horse);
        horseDao.delete(id);
    }

    @Test
    public void saveUpdateTest() {
        assertNotNull(testHorseId);
        testHorse.setId(testHorseId);
        if (testHorse.getId() == null) {
        } else {
            horseDao.update(testHorse);
        }
        Horse horse = horseDao.get(testHorseId);
        assertEquals(testHorse, horse);
    }

    @Test
    public void deleteTest() {
        testHorse.setNickName("Delete");
        Long id = horseDao.insert(testHorse);
        boolean delete = horseDao.delete(id);
        assertTrue(delete);
    }

    @Test
    public void saveAllTest() throws NoSuchEntityException {
        Horse testHorse1 = new Horse();
        testHorse1.setNickName("TestNickName1");
        testHorse1.setAge(3);
        testHorse1.setEquipmentWeight(60);
        testHorse1.setForm("TestForm1");
        testHorse1.setOwner("TestOwner1");
        List<Horse> arrayList = new ArrayList<>();
        testHorse.setNickName("TestNickName2");
        arrayList.addAll(Arrays.asList(testHorse, testHorse1));
        horseService.saveAll(arrayList);
        Horse horse = horseDao.getByNickName("TestNickName2");
        Horse horse1 = horseDao.getByNickName("TestNickName1");
        testHorse.setId(horse.getId());
        testHorse1.setId(horse1.getId());
        assertEquals(testHorse, horse);
        assertEquals(testHorse1, horse1);
        horseDao.delete(horse1.getId());
        horseDao.delete(horse.getId());
    }

    @Test
    public void getAllTest() {
        List<Horse> all = horseDao.getAll();
        assertNotNull(all);
        assertNotNull(all.get(0).getId());
    }

    @Test
    public void getHorseByNickNameTest() {
        Horse testLoginNew = horseDao.getByNickName("faster1");
        testHorse.setId(testHorseId);
        assertEquals("faster1", testLoginNew.getNickName());
    }

    @Test
    public void getByRaceDetailTest(){
        Horse horse=horseDao.get(1L);
        Horse horse1 = horseService.getByRaceDetail(1L);
        assertEquals(horse, horse1);
    }
}
