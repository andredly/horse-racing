package com.charniauski.training.horsesrace.services.impl;

import com.charniauski.training.horsesrace.daodb.BetDao;
import com.charniauski.training.horsesrace.daodb.ClientDao;
import com.charniauski.training.horsesrace.daodb.GenericDao;
import com.charniauski.training.horsesrace.datamodel.Bet;
import com.charniauski.training.horsesrace.datamodel.Client;
import com.charniauski.training.horsesrace.services.BetService;
import com.charniauski.training.horsesrace.services.ClientService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by Andre on 19.10.2016.
 */
@Service
public class BetServiceImpl extends AbstractService<Bet,Long> implements BetService {


    @Inject
    private BetDao betDao;


    @Override
    public GenericDao getGenericDao() {
        return betDao;
    }
}
