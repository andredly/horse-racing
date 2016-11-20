package com.charniauski.training.horsesrace.services;


import com.charniauski.training.horsesrace.datamodel.Horse;
import com.charniauski.training.horsesrace.services.exception.NoSuchEntityException;
import com.charniauski.training.horsesrace.services.testutil.BaseCreator;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
@TestExecutionListeners(listeners = {DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class, TransactionalTestExecutionListener.class})
public class HorseServiceTest {


    @Inject
    private HorseService horseService;

    @Inject
    private BaseCreator baseCreator;

    private Horse testHorse;

    private Long testHorseId;
    @Parameterized.Parameters
    public static void getBaseCreator(BaseCreator baseCreator){
//        baseCreator.createRelationDB();
    }

    @BeforeClass
    public static void prepareTestData() {
        ClassPathXmlApplicationContext springContext = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        BaseCreator baseCreator1 = (BaseCreator) springContext.getBean("baseCreator");
        baseCreator1.createRelationDB();
    }

    @AfterClass
    public static void deleteTestData() {
//        System.out.println("deleteTestData");
    }

    @Before
    public void prepareMethodData() {
       baseCreator.createXMLDB();
        testHorse = new Horse();
        testHorse.setNickName("TestNickName");
        testHorse.setAge(3);
        testHorse.setEquipmentWeight(60);
        testHorse.setForm("TestForm");
        testHorse.setOwner("TestOwner");
        testHorseId = 3L;
    }

    @After
    public void deleteMethodData() {
        testHorse = null;
        testHorseId = null;
    }


    @Test
    public void getByIdTest() {
        testHorse.setId(testHorseId);
        Horse horse = horseService.get(testHorse.getId());
        assertNotNull(horse);
        assertEquals(testHorse.getId(), horse.getId());
    }

    @Test
    public void saveInsertTest() {
        Long id = null;
        testHorse.setNickName("TestNickName1");
        id = horseService.save(testHorse);
        Horse horse = horseService.get(id);
        assertNotNull(horse);
        testHorse.setId(id);
        assertEquals(testHorse, horse);
        horseService.delete(testHorse);
    }

    @Test
    public void saveUpdateTest() {
        assertNotNull(testHorseId);
        testHorse.setId(testHorseId);
        horseService.save(testHorse);
        Horse horse = horseService.get(testHorseId);
        assertEquals(testHorse, horse);
    }

    @Test
    public void deleteTest() {
        testHorse.setNickName("Delete");
        Long id = horseService.save(testHorse);
        testHorse.setId(id);
        boolean delete = horseService.delete(testHorse);
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
        Horse horse = horseService.getByNickName("TestNickName2");
        Horse horse1 = horseService.getByNickName("TestNickName1");
        testHorse.setId(horse.getId());
        testHorse1.setId(horse1.getId());
        assertEquals(testHorse, horse);
        assertEquals(testHorse1, horse1);
        horseService.delete(horse1);
        horseService.delete(horse);
    }

    @Test
    public void getAllTest() {
        List<Horse> all = horseService.getAll();
        assertNotNull(all);
        assertNotNull(all.get(0).getId());
    }

    @Test
    public void getHorseByNickNameTest() {
        Horse testLoginNew = horseService.getByNickName("faster1");
        testHorse.setId(testHorseId);
        assertEquals("faster1", testLoginNew.getNickName());
    }

    @Test
    public void getByRaceDetailTest() {
        Horse horse = horseService.get(1L);
        Horse horse1 = horseService.getByRaceDetail(1L);
        assertEquals(horse, horse1);
    }
}
