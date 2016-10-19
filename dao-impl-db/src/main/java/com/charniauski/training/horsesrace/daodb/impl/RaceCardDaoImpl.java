package com.charniauski.training.horsesrace.daodb.impl;

import com.charniauski.training.horsesrace.daodb.RaceCardDao;
import com.charniauski.training.horsesrace.datamodel.RaceCard;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Andre on 19.10.2016.
 */
@Repository
public class RaceCardDaoImpl implements RaceCardDao {
    @Override
    public RaceCard get(Long id) {
        // TODO: 19.10.2016
        return null;
    }

    @Override
    public void insert(RaceCard entity) {
        // TODO: 19.10.2016
    }

    @Override
    public void update(RaceCard entity) {
        // TODO: 19.10.2016
    }

    @Override
    public void delete(Long id) {
        // TODO: 19.10.2016
    }

    @Override
    public List<RaceCard> getAll() {
        // TODO: 19.10.2016
        return null;
    }
}
