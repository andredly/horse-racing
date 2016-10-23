package com.charniauski.training.horsesrace.daodb.impl;

import com.charniauski.training.horsesrace.daodb.RaceCardDao;
import com.charniauski.training.horsesrace.datamodel.Command;
import com.charniauski.training.horsesrace.datamodel.RaceCard;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Andre on 19.10.2016.
 */
@Repository
public class RaceCardDaoImpl extends AbstractDao<RaceCard,Long> {
    public RaceCardDaoImpl() {
        super(RaceCard.class);
    }
}
