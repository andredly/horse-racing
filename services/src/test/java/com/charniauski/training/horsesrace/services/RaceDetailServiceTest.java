package com.charniauski.training.horsesrace.services;

import com.charniauski.training.horsesrace.daodb.RaceDetailDao;
import com.charniauski.training.horsesrace.datamodel.RaceDetail;
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
public class RaceDetailServiceTest {

    @Inject
    private RaceDetailService raceDetailService;

    @Inject
    private RaceDetailDao raceDetailDao;

    private RaceDetail testRaceDetail;
    private Long testRaceDetailId;


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
        RaceDetail raceDetail = raceDetailDao.get(testRaceDetail.getId());
        assertNotNull(raceDetail);
        assertEquals(testRaceDetail.getId(), raceDetail.getId());
    }

    @Test
    public void saveInsertTest() {
        Long id = null;
        if (testRaceDetail.getId() == null) {
            testRaceDetail.setHorseId(3L);
            testRaceDetail.setNumberStartBox(12);
            testRaceDetail.setCommandId(3L);
            id = raceDetailDao.insert(testRaceDetail);
        } else {
        }
        RaceDetail raceDetail = raceDetailDao.get(id);
        assertNotNull(raceDetail);
        testRaceDetail.setId(id);
        assertEquals(testRaceDetail, raceDetail);
        raceDetailDao.delete(id);
    }

    @Test
    public void saveUpdateTest() {
        assertNotNull(testRaceDetailId);
        testRaceDetail.setId(testRaceDetailId);
        if (testRaceDetail.getId() == null) {
        } else {
            raceDetailDao.update(testRaceDetail);
        }
        RaceDetail raceDetail = raceDetailDao.get(testRaceDetailId);
        assertEquals(testRaceDetail, raceDetail);
    }

    @Test
    public void deleteTest() {
        testRaceDetail.setHorseId(3L);
        testRaceDetail.setNumberStartBox(3);
        testRaceDetail.setCommandId(3L);
        Long id = raceDetailDao.insert(testRaceDetail);
        boolean delete = raceDetailDao.delete(id);
        assertTrue(delete);
    }

    @Test
    public void saveAllTest() throws NoSuchEntityException {
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
        raceDetailDao.delete(raceCardAndHorse1.getId());
        raceDetailDao.delete(raceCardAndHorse.getId());
    }

    @Test
    public void getAllTest() {
        List<RaceDetail> all = raceDetailDao.getAll();
        assertNotNull(all);
        assertNotNull(all.get(0).getId());
    }

    @Test
    public void saveHorseResultTest() {
        RaceDetail raceDetail = raceDetailDao.get(2L);
        raceDetail.setHorseResult(2);
        boolean b = raceDetailService.saveHorseResult(1L, 2L, 2);
        RaceDetail raceDetail1 = raceDetailService.get(2L);
        assertEquals(raceDetail, raceDetail1);
    }

    @Test
    public void getByRaceCardAndHorseTest() {
        testRaceDetail.setRaceCardId(1L);
        testRaceDetail.setHorseId(3L);
        testRaceDetail.setCommandId(3L);
        testRaceDetail.setNumberStartBox(10);
        Long id = raceDetailDao.insert(testRaceDetail);
        RaceDetail raceDetail1 = raceDetailService.getByRaceCardAndHorse(1L, 3L);
        RaceDetail raceDetail = raceDetailDao.get(id);
        assertEquals(raceDetail, raceDetail1);
        raceDetailDao.delete(raceDetail.getId());
    }

    @Test
    public void getByRaceCardAndCommandTest() {
        testRaceDetail.setRaceCardId(1L);
        testRaceDetail.setHorseId(3L);
        testRaceDetail.setCommandId(3L);
        testRaceDetail.setNumberStartBox(10);
        Long id = raceDetailDao.insert(testRaceDetail);
        RaceDetail raceDetail1 = raceDetailService.getByRaceCardAndCommand(1L, 3L);
        RaceDetail raceDetail = raceDetailDao.get(id);
        assertEquals(raceDetail, raceDetail1);
        raceDetailDao.delete(raceDetail.getId());
    }

    @Test
    public void getByRaceCardAndNumberStartBoxTest() {
        testRaceDetail.setRaceCardId(1L);
        testRaceDetail.setHorseId(3L);
        testRaceDetail.setCommandId(3L);
        testRaceDetail.setNumberStartBox(10);
        Long id = raceDetailDao.insert(testRaceDetail);
        RaceDetail raceDetail1 = raceDetailService.getByRaceCardAndNumberStartBox(1L, 10);
        RaceDetail raceDetail = raceDetailDao.get(id);
        assertEquals(raceDetail, raceDetail1);
        raceDetailDao.delete(raceDetail.getId());
    }

    @Test
    public void getByRaceCardTest() {
        RaceDetail raceDetail = raceDetailDao.get(1L);
        List<RaceDetail> raceDetails = raceDetailService.getByRaceCard(raceDetail.getRaceCardId());
        raceDetails.forEach(raceDetail1 -> assertEquals(raceDetail.getRaceCardId(), raceDetail1.getRaceCardId()));
    }
//
//    RaceDetailWrapper getRaceDetailWrapper(Long raceDetailId);

}
