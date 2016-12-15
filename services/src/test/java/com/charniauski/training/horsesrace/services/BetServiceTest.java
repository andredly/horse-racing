package com.charniauski.training.horsesrace.services;


import com.charniauski.training.horsesrace.datamodel.*;
import com.charniauski.training.horsesrace.datamodel.enums.StatusBet;
import com.charniauski.training.horsesrace.services.exception.NoSuchEntityException;
import com.charniauski.training.horsesrace.services.testutil.BaseCreator;
import com.charniauski.training.horsesrace.services.wrapper.BetWrapper;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
@TestExecutionListeners(listeners = {DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class, TransactionalTestExecutionListener.class})
public class BetServiceTest {

    @Inject
    private BetService betService;

    @Inject
    private HorseService horseService;

    @Inject
    private RaceCardService raceCardService;

    @Inject
    private RaceDetailService raceDetailService;

    @Inject
    private AccountService accountService;

    @Inject
    private RacecourseService racecourseService;

    @Inject
    private BaseCreator baseCreator;

    @Inject
    private EventService eventService;

    private Bet testBet;
    private Long testBetId;

    @BeforeClass
    public static void prepareTestData() {
        ClassPathXmlApplicationContext springContext = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        BaseCreator baseCreator1 = (BaseCreator) springContext.getBean("baseCreator");
        baseCreator1.createRelationDB();
        baseCreator1.createXMLDB();
    }

    @Before
    public void prepareMethodData() {
        baseCreator.createXMLDB();
        testBet = new Bet();
        testBet.setDateBet(new Timestamp(new Date().getTime()));
        testBet.setEventId(1L);
        testBet.setCoefficientBet(1.0);
        testBet.setStatusBet(StatusBet.ACTIVE);
        testBet.setAccountId(1L);
        testBet.setSum(20.0);
        testBetId = 1L;
    }

    @After
    public void deleteMethodData() {
        testBet = null;
        testBetId = null;
    }


    @Test
    public void getByIdTest() {
        testBet.setId(testBetId);
        Bet bet = betService.get(testBet.getId());
        assertNotNull(bet);
        assertEquals(testBet.getId(), bet.getId());
    }

    @Test
    public void saveInsertTest() {
        testBet.setEventId(2L);
        testBet.setCoefficientBet(1.0);
        testBet.setStatusBet(StatusBet.ACTIVE);
        testBet.setAccountId(2L);
        testBet.setSum(20.0);
        Long id = betService.save(testBet);
        Bet bet = betService.get(id);
        assertNotNull(bet);
        testBet.setDateBet(new Date(testBet.getDateBet().getTime()));
        testBet.setId(id);
        assertEquals(testBet, bet);
        bet.setId(id);
        betService.delete(bet.getId());
    }


    @Test
    public void saveUpdateTest() {
        assertNotNull(testBetId);
        testBet.setId(3L);
        testBet.setAccountId(2L);
        betService.get(testBetId);
        betService.save(testBet);
        Bet bet = betService.get(3L);
        testBet.setDateBet(new Date(testBet.getDateBet().getTime()));
        assertEquals(testBet, bet);
    }

    @Test
    public void deleteTest() {
        testBet.setEventId(1L);
        testBet.setCoefficientBet(1.0);
        testBet.setStatusBet(StatusBet.ACTIVE);
        testBet.setAccountId(3L);
        testBet.setSum(20.0);
        Long id = betService.save(testBet);
        testBet.setId(id);
        boolean delete = betService.delete(testBet.getId());
        assertTrue(delete);
    }

    @Test
    public void saveAllTest() throws NoSuchEntityException {
        Bet testBet2 = new Bet();
        testBet2.setDateBet(new Timestamp(new Date().getTime()));
        testBet2.setEventId(2L);
        testBet2.setCoefficientBet(1.0);
        testBet2.setStatusBet(StatusBet.ACTIVE);
        testBet2.setAccountId(2L);
        testBet2.setSum(20.0);
        List<Bet> arrayList = new ArrayList<>();
        testBet.setEventId(3L);
        testBet.setCoefficientBet(1.0);
        testBet.setStatusBet(StatusBet.ACTIVE);
        testBet.setAccountId(1L);
        testBet.setSum(10.0);
        arrayList.addAll(Arrays.asList(testBet, testBet2));
        betService.saveAll(arrayList);
        Bet bet = betService.get(6L);
        Bet bet2 = betService.get(7L);
        testBet.setId(bet.getId());
        testBet2.setId(bet2.getId());
        testBet.setDateBet(new Date(testBet.getDateBet().getTime()));
        testBet2.setDateBet(new Date(testBet2.getDateBet().getTime()));
        assertEquals(testBet, bet);
        assertEquals(testBet2, bet2);
//        betService.delete(bet.getId());
//        betService.delete(bet2.getId());
    }

    @Test
    public void getAllTest() {
        List<Bet> all = betService.getAll();
        assertNotNull(all);
        assertNotNull(all.get(0).getId());
    }

    @Test
    public void getAllByLoginTest() {
        Account account = accountService.getByLogin("log");
        List<Bet> bets = betService.getAllByLogin("log");
        bets.forEach(bet -> assertEquals(account.getId(), bet.getAccountId()));
    }


    @Test
    public void getAllByLoginAndStatusBetTest() {
        Account account = accountService.getByLogin("log");
        List<Bet> all = betService.getAllByLoginAndStatusBet("log", StatusBet.CLOSED);
        for (Bet bet : all) {
            assertEquals(account.getId(), bet.getAccountId());
            assertEquals(StatusBet.CLOSED, bet.getStatusBet());
        }
    }

    @Test
    public void getAllByStatusBetTest() {
        List<Bet> all = betService.getAllByStatusBet(StatusBet.CLOSED);
        for (Bet bet : all) {
            assertEquals(StatusBet.CLOSED, bet.getStatusBet());
        }
    }

    @Test
    public void getByAccountAndEventTest() {
        Account account = accountService.getByLogin("log");
        Event event = eventService.get(3L);
        testBet.setAccountId(account.getId());
        testBet.setEventId(event.getId());
        Long id = betService.save(testBet);
        Bet bet1 = betService.get(id);
        Bet bet = betService.getByAccountAndEvent("log", 3L);
        assertEquals(bet1, bet);
        betService.delete(bet1.getId());
    }

    @Test
    public void getBetWrapperTest() {
        BetWrapper betWrapper = betService.getAllDataForBet(1L);
        Bet bet = betService.get(1L);
        BetWrapper betWrapper1 = new BetWrapper();
        betWrapper1.setBet(bet);
        Event event = eventService.get(bet.getEventId());
        betWrapper1.setEvent(event);
        RaceDetail raceDetail = raceDetailService.get(event.getRaceDetailId());
        betWrapper1.setRaceDetail(raceDetail);
        RaceCard raceCard = raceCardService.get(raceDetail.getRaceCardId());
        betWrapper1.setRaceCard(raceCard);
        betWrapper1.setHorse(horseService.get(raceDetail.getHorseId()));
        betWrapper1.setRacecourse(racecourseService.get(raceCard.getRacecourseId()));
        assertNotNull(betWrapper);
        assertEquals(betWrapper, betWrapper1);
    }
}
