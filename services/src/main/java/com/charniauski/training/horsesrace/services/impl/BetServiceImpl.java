package com.charniauski.training.horsesrace.services.impl;

import com.charniauski.training.horsesrace.daodb.BetDao;
import com.charniauski.training.horsesrace.daodb.GenericDao;
import com.charniauski.training.horsesrace.datamodel.*;
import com.charniauski.training.horsesrace.services.AccountService;
import com.charniauski.training.horsesrace.services.BetService;
import com.charniauski.training.horsesrace.services.EventService;
import com.charniauski.training.horsesrace.services.exception.NoSuchEntityException;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

/**
 * Created by Andre on 19.10.2016.
 */
@Service
public class BetServiceImpl extends AbstractService<Bet,Long> implements BetService {
    private static final Logger LOGGER = LoggerFactory.getLogger(BetServiceImpl.class);

    @Inject
    private BetDao betDao;

    @Inject
    private EventService eventService;

    @Inject
    private AccountService accountService;


    @Override
    public GenericDao getGenericDao() {
        return betDao;
    }

    @Transactional
    @Override
    public Long save(Bet bet)  {
        Validate.notNull(bet.getDateBet(), "Arguments getDateBet may not by null");
        Validate.notNull(bet.getEventId(), "Arguments EventId may not by null");
        Validate.notNull(bet.getAccountId(), "Arguments AccountId may not by null");
        Validate.notNull(bet.getBetType(), "Arguments BetType may not by null");
        Validate.notNull(bet.getSum(), "Arguments Sum may not by null");
        Validate.notNull(bet.getCoefficientBet(),"Arguments CoefficientBet may not by null");
        Validate.notNull(bet.getStatusBet(),"Arguments StatusBet may not by null");

        Event event = eventService.get(bet.getEventId());
        Account account=accountService.get(bet.getAccountId());

        if (event == null||account==null)
            throw new NoSuchEntityException("Event or Account not found. Enter valid id!");
        Long betId;
        if (bet.getId() == null) {
            if (bet.getCalculate() != null)
                throw new IllegalArgumentException("Calculate must not be if insert");
            betId = betDao.insert(bet);
        } else {
            betDao.update(bet);
            betId=bet.getId();
        }
        return betId;
    }
}
