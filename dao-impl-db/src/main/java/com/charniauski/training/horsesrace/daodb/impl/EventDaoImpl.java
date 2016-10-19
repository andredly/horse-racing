package com.charniauski.training.horsesrace.daodb.impl;

import com.charniauski.training.horsesrace.daodb.EventDao;
import com.charniauski.training.horsesrace.datamodel.Event;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Andre on 19.10.2016.
 */
@Repository
public class EventDaoImpl implements EventDao {
    @Override
    public Event get(Long id) {
        // TODO: 19.10.2016
        return null;
    }

    @Override
    public void insert(Event entity) {
        // TODO: 19.10.2016
    }

    @Override
    public void update(Event entity) {
        // TODO: 19.10.2016
    }

    @Override
    public void delete(Long id) {
        // TODO: 19.10.2016
    }

    @Override
    public List<Event> getAll()
    {    // TODO: 19.10.2016
        return null;
    }
}
