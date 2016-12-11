package com.charniauski.training.horsesrace.services;

import com.charniauski.training.horsesrace.datamodel.*;
import com.charniauski.training.horsesrace.services.exception.NoSuchEntityException;
import com.charniauski.training.horsesrace.services.testutil.BaseCreator;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
@TestExecutionListeners(listeners = {DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class, TransactionalTestExecutionListener.class})
public class RaceDetailServiceTest {


    @Inject
    private RaceDetailService raceDetailService;

    @Inject
    private BaseCreator baseCreator;
    @Inject
    private HorseService horseService;
    @Inject
    private CommandService commandService;
    @Inject
    private RaceCardService raceCardService;
    @Inject
    private EventService eventService;

    private RaceDetail testRaceDetail;
    private Long testRaceDetailId;

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
        testRaceDetail = new RaceDetail();
        testRaceDetail.setRaceCardId(1L);
        testRaceDetail.setHorseId(1L);
        testRaceDetail.setNumberStartBox(1);
        testRaceDetail.setCommandId(1L);
        testRaceDetailId = 1L;
    }

    @After
    public void deleteMethodData() {
        testRaceDetail = null;
        testRaceDetailId = null;
    }


    @Test
    public void getByIdTest() {
        testRaceDetail.setId(testRaceDetailId);
        RaceDetail raceDetail = raceDetailService.get(testRaceDetail.getId());
        assertNotNull(raceDetail);
        assertEquals(testRaceDetail.getId(), raceDetail.getId());
    }

    @Test
    public void saveInsertTest() {
        Long id = null;
            testRaceDetail.setHorseId(3L);
            testRaceDetail.setNumberStartBox(12);
            testRaceDetail.setCommandId(3L);
            id = raceDetailService.save(testRaceDetail);
        RaceDetail raceDetail = raceDetailService.get(id);
        assertNotNull(raceDetail);
        testRaceDetail.setId(id);
        assertEquals(testRaceDetail, raceDetail);
        raceDetailService.delete(testRaceDetail.getId());
    }

    @Test
    public void saveUpdateTest() {
        assertNotNull(testRaceDetailId);
        testRaceDetail.setId(testRaceDetailId);
            raceDetailService.save(testRaceDetail);
        RaceDetail raceDetail = raceDetailService.get(testRaceDetailId);
        assertEquals(testRaceDetail, raceDetail);
    }

    @Test
    public void deleteTest() {
        testRaceDetail.setHorseId(3L);
        testRaceDetail.setNumberStartBox(3);
        testRaceDetail.setCommandId(3L);
        Long id = raceDetailService.save(testRaceDetail);
        testRaceDetail.setId(id);
        boolean delete = raceDetailService.delete(testRaceDetail.getId());
        assertTrue(delete);
    }

    @Test
    public void saveAllTest() {
        RaceDetail testRaceDetail2 = new RaceDetail();
        testRaceDetail2.setRaceCardId(1L);
        testRaceDetail2.setHorseId(3L);
        testRaceDetail2.setNumberStartBox(3);
        testRaceDetail2.setCommandId(3L);
        List<RaceDetail> arrayList = new ArrayList<>();
        testRaceDetail.setHorseId(4L);
        testRaceDetail.setNumberStartBox(4);
        testRaceDetail.setCommandId(4L);
        arrayList.addAll(Arrays.asList(testRaceDetail, testRaceDetail2));
        raceDetailService.saveAll(arrayList);
        RaceDetail raceCardAndHorse1 = raceDetailService.getByRaceCardAndHorse(1L, 3L);
        RaceDetail raceCardAndHorse = raceDetailService.getByRaceCardAndHorse(1L, 4L);
        testRaceDetail.setId(raceCardAndHorse.getId());
        testRaceDetail2.setId(raceCardAndHorse1.getId());
        assertEquals(testRaceDetail, raceCardAndHorse);
        assertEquals(testRaceDetail2, raceCardAndHorse1);
        raceDetailService.delete(raceCardAndHorse1.getId());
        raceDetailService.delete(raceCardAndHorse.getId());
    }

    @Test
    public void getAllTest() {
        List<RaceDetail> all = raceDetailService.getAll();
        assertNotNull(all);
        assertNotNull(all.get(0).getId());
    }

    @Test
    public void getByRaceCardAndHorseTest() {
        testRaceDetail.setRaceCardId(2L);
        testRaceDetail.setHorseId(4L);
        testRaceDetail.setCommandId(4L);
        testRaceDetail.setNumberStartBox(10);
        Long id = raceDetailService.save(testRaceDetail);
        System.out.println(id);
        RaceDetail raceDetail1 = raceDetailService.getByRaceCardAndHorse(2L, 4L);
        System.out.println(raceDetail1.getId());
        RaceDetail raceDetail = raceDetailService.get(id);
        assertEquals(raceDetail, raceDetail1);
        raceDetailService.delete(raceDetail.getId());
    }

    @Test
    public void getByRaceCardAndCommandTest() {
        testRaceDetail.setRaceCardId(1L);
        testRaceDetail.setHorseId(3L);
        testRaceDetail.setCommandId(3L);
        testRaceDetail.setNumberStartBox(10);
        Long id = raceDetailService.save(testRaceDetail);
        RaceDetail raceDetail1 = raceDetailService.getByRaceCardAndCommand(1L, 3L);
        RaceDetail raceDetail = raceDetailService.get(id);
        assertEquals(raceDetail, raceDetail1);
        raceDetailService.delete(raceDetail.getId());
    }

    @Test
    public void getByRaceCardAndNumberStartBoxTest() {
        testRaceDetail.setRaceCardId(1L);
        testRaceDetail.setHorseId(3L);
        testRaceDetail.setCommandId(3L);
        testRaceDetail.setNumberStartBox(10);
        Long id = raceDetailService.save(testRaceDetail);
        RaceDetail raceDetail1 = raceDetailService.getByRaceCardAndNumberStartBox(1L, 10);
        RaceDetail raceDetail = raceDetailService.get(id);
        assertEquals(raceDetail, raceDetail1);
        raceDetailService.delete(raceDetail.getId());
    }

    @Test
    public void getByRaceCardTest() {
        RaceDetail raceDetail = raceDetailService.get(1L);
        List<RaceDetail> raceDetails = raceDetailService.getAllByRaceCard(raceDetail.getRaceCardId());
        raceDetails.forEach(raceDetail1 -> assertEquals(raceDetail.getRaceCardId(), raceDetail1.getRaceCardId()));
    }


    @Test
   public void getRaceDetailWrapperTest(){
        RaceDetailWrapper raceDetailWrapper = raceDetailService.getRaceDetailWrapper(1L);
        RaceDetail raceDetail=raceDetailService.get(1L);
        Horse horse=horseService.get(raceDetail.getHorseId());
        Command command = commandService.get(raceDetail.getCommandId());
        List<Event> allByRaceDetail = eventService.getAllByRaceDetail(1L);
        RaceCard raceCard = raceCardService.get(raceDetail.getRaceCardId());
        RaceDetailWrapper raceDetailWrapper1=new RaceDetailWrapper();
        raceDetailWrapper1.setCommand(command);
        raceDetailWrapper1.setEvents(allByRaceDetail);
        raceDetailWrapper1.setHorse(horse);
        raceDetailWrapper1.setRaceCard(raceCard);
        raceDetailWrapper1.setRaceDetail(raceDetail);
        assertEquals(raceDetailWrapper1,raceDetailWrapper);
    }

}
