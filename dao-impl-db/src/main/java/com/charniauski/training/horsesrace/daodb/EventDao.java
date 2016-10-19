package com.charniauski.training.horsesrace.daodb;

import com.charniauski.training.horsesrace.datamodel.Event;

import java.util.List;

/**
 * Created by Andre on 19.10.2016.
 */
public interface EventDao {

    Event get(Long id);

    void insert(Event entity);

    void update(Event entity);

    void delete(Long id);

    List<Event> getAll();
}
