package com.charniauski.training.horsesrace.services;

import com.charniauski.training.horsesrace.daodb.HorseDao;
import com.charniauski.training.horsesrace.datamodel.Command;
import com.charniauski.training.horsesrace.datamodel.Horse;
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

    private Long testCommandId;

    private Command command;

    @Inject
    private CommandService commandService;

    @BeforeClass
    public static void prepareTestData() {

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
        testHorseId = horseDao.insert(testHorse);
    }

    @After
    public void deleteMethodData() {
        horseDao.delete(testHorseId);
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
        Long id = testHorse.getId();
        Horse horse1 = horseDao.get(id);
        assertNull(horse1);
        if (testHorse.getId() == null) {
            testHorse.setNickName("TestNickName1");
            id = horseDao.insert(testHorse);
        } else {
            horseDao.update(testHorse);
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
            testHorseId = horseDao.insert(testHorse);
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
    public void saveAllTest() {
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
    public void getAll() {
        List<Horse> all = horseDao.getAll();
        assertNotNull(all);
        assertNotNull(all.get(0).getId());
    }

    @Test
    public void getHorseByLogin(){
        Horse testLoginNew = horseDao.getByNickName("TestNickName");
        testHorse.setId(testHorseId);
        assertEquals(testHorse,testLoginNew);
    }

}
