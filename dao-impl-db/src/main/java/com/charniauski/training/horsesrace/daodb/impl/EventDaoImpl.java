package com.charniauski.training.horsesrace.daodb.impl;

import com.charniauski.training.horsesrace.datamodel.Command;
import com.charniauski.training.horsesrace.datamodel.Event;
import org.springframework.stereotype.Repository;

/**
 * Created by Andre on 19.10.2016.
 */
@Repository
public class EventDaoImpl extends AbstractDao<Event,Long> {
    public EventDaoImpl() {
        super(Event.class);
    }
}
