package com.charniauski.training.horsesrace.services.impl;

import com.charniauski.training.horsesrace.daoapi.BetDao;
import com.charniauski.training.horsesrace.daoapi.GenericDao;
import com.charniauski.training.horsesrace.datamodel.*;
import com.charniauski.training.horsesrace.datamodel.enums.StatusBet;
import com.charniauski.training.horsesrace.services.*;
import com.charniauski.training.horsesrace.services.cacherequest.Cached;
import com.charniauski.training.horsesrace.services.exception.NoSuchEntityException;
import com.charniauski.training.horsesrace.services.wrapper.BetWrapper;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Andre on 19.10.2016.
 */
@Service
public class BetServiceImpl extends AbstractService<Bet, Long> implements BetService {
    private static final Logger LOGGER = LoggerFactory.getLogger(BetServiceImpl.class);

    @Inject
    private BetDao betDao;

    @Inject
    private EventService eventService;

    @Inject
    private AccountService accountService;

    @Inject
    private RaceCardService raceCardService;

    @Inject
    private RaceDetailService raceDetailService;

    @Inject
    private RacecourseService racecourseService;

    @Inject
    private HorseService horseService;


    @Override
    public GenericDao<Bet, Long> getGenericDao() {
        return betDao;
    }

    @Transactional
    @Override
    public Long save(Bet bet) {
//        validateDataBet(bet);
        Event event = eventService.get(bet.getEventId());
        Account account = accountService.get(bet.getAccountId());
        Validate.isTrue(!account.getIsDelete(), "This account is deleted");
        if (event == null || account == null)
            throw new NoSuchEntityException("Event or Account not found. Enter valid id!");
        Long betId;
        if (bet.getId() == null) {
            bet.setCoefficientBet(event.getCoefficientEvent());
            Date dateStart = raceCardService.getDateStartByEvent(bet.getEventId());
            bet.setDateBet(new Timestamp(new Date().getTime()));
            if (bet.getDateBet().after(dateStart)) throw new DateTimeException("Date bet after date start");
            betId = betDao.insert(bet);
            LOGGER.info("Bet id={} for account with login={}  is save", betId, account.getLogin());
        } else {
            betDao.update(bet);
            betId = bet.getId();
            LOGGER.info("Bet id={} for account with login={}  is update", bet.getId(), account.getLogin());
        }
        return betId;
    }

//    private void validateDataBet(Bet bet) {
//        Validate.notNull(bet.getEventId(), "Arguments EventId may not by null");
//        Validate.notNull(bet.getAccountId(), "Arguments AccountId may not by null");
//        Validate.notNull(bet.getSum(), "Arguments Sum may not by null");
//        Validate.isTrue(bet.getSum()>=0.0,"Sum Arguments Sum may not by <=0",bet.getSum());
//    }

    @Cached(timeToLiveSeconds = 100)
    @Override
    public List<Bet> getAllByLogin(String login) {
//        validateSetLogin(login);
        return betDao.getAllByLogin(login);
    }

//    private void validateSetLogin(String login) {
//        Validate.notNull(login);
//        Validate.notEmpty(login);
//    }

    @Cached
    @Override
    public List<Bet> getAllByLoginAndStatusBet(String login, StatusBet statusBet) {
//        validateSetLogin(login);
        return betDao.getAllByLoginAndStatusBet(login, statusBet);
    }

    @Cached(timeToLiveSeconds = 100)
    @Override
    public List<Bet> getAllByStatusBet(StatusBet statusBet) {
        return betDao.getAllByStatusBet(statusBet);
    }

    @Cached(timeToLiveSeconds = 100)
    @Override
    public Bet getByAccountAndEvent(String login, Long eventId) {
//        validateSetLogin(login);
        return betDao.getByAccountAndEvent(login, eventId);
    }

    @Override
    public BetWrapper getAllDataForBet(Long id) {
        Bet bet = get(id);
        if (bet==null){throw new NoSuchEntityException("Bet not found");}
        BetWrapper betWrapper = new BetWrapper();
        betWrapper.setBet(bet);
        Event event = eventService.get(bet.getEventId());
        betWrapper.setEvent(event);
        RaceDetail raceDetail = raceDetailService.get(event.getRaceDetailId());
        betWrapper.setRaceDetail(raceDetail);
        RaceCard raceCard = raceCardService.get(raceDetail.getRaceCardId());
        betWrapper.setRaceCard(raceCard);
        betWrapper.setRacecourse(racecourseService.get(raceCard.getRacecourseId()));
        betWrapper.setHorse(horseService.get(raceDetail.getHorseId()));
        return betWrapper;
    }

    @Override
    public List<BetWrapper> getAllDataByLogin(String login) {
        List<Bet> list = getAllByLogin(login);
        List<BetWrapper> wrapperList = new ArrayList<>();
        list.forEach(bet -> wrapperList.add(getAllDataForBet(bet.getId())));
        return wrapperList;
    }

}
