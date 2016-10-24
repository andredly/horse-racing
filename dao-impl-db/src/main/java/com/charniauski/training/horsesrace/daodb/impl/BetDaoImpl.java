package com.charniauski.training.horsesrace.daodb.impl;

import com.charniauski.training.horsesrace.daodb.BetDao;
import com.charniauski.training.horsesrace.datamodel.Bet;
import org.springframework.stereotype.Repository;

/**
 * Created by Andre on 19.10.2016.
 */
@Repository
public class BetDaoImpl extends AbstractDao<Bet,Long> implements BetDao{

    public BetDaoImpl() {
        super(Bet.class);
    }
}
