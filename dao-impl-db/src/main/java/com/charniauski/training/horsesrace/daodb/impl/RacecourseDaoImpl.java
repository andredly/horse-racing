package com.charniauski.training.horsesrace.daodb.impl;

import com.charniauski.training.horsesrace.daodb.RacecourseDao;
import com.charniauski.training.horsesrace.datamodel.Racecourse;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Andre on 19.10.2016.
 */
@Repository
public class RacecourseDaoImpl implements RacecourseDao {
    @Override
    public Racecourse get(Long id) {
        // TODO: 19.10.2016
        return null;
    }

    @Override
    public void insert(Racecourse entity) {
        // TODO: 19.10.2016
    }

    @Override
    public void update(Racecourse entity) {
        // TODO: 19.10.2016
    }

    @Override
    public void delete(Long id) {
        // TODO: 19.10.2016
    }

    @Override
    public List<Racecourse> getAll() {
        // TODO: 19.10.2016
        return null;
    }
}
