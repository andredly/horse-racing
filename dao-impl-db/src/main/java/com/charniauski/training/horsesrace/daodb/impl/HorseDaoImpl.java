package com.charniauski.training.horsesrace.daodb.impl;

import com.charniauski.training.horsesrace.daodb.HorseDao;
import com.charniauski.training.horsesrace.datamodel.Horse;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Andre on 19.10.2016.
 */
@Repository
public class HorseDaoImpl implements HorseDao {
    @Override
    public Horse get(Long id) {
        // TODO: 19.10.2016
        return null;
    }

    @Override
    public void insert(Horse entity) {
        // TODO: 19.10.2016
    }

    @Override
    public void update(Horse entity) {
        // TODO: 19.10.2016
    }

    @Override
    public void delete(Long id) {
        // TODO: 19.10.2016
    }

    @Override
    public List<Horse> getAll()
    {    // TODO: 19.10.2016
        return null;
    }
}
