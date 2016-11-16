package com.charniauski.training.horsesrace.daoxml.impl;


import com.charniauski.training.horsesrace.daoapi.EventDao;
import com.charniauski.training.horsesrace.datamodel.Event;
import com.charniauski.training.horsesrace.datamodel.enums.ResultEvent;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Andre on 19.10.2016.
 */
@Repository
public class EventDaoImpl extends AbstractDao<Event,Long> implements EventDao {

    private final AtomicLong sequence=new AtomicLong(1L);
    @Override
    public List<Event> getAllByRaceDetail(Long raceDetail) {
        List<Event> events = readCollection();
        Iterator<Event> eventIterator = events.iterator();
        while (eventIterator.hasNext()) {
            Event next = eventIterator.next();
            if (!next.getRaceDetailId().equals(raceDetail)) {
                eventIterator.remove();
            }
        }
        return events;
    }

    @Override
    public List<Event> getAllByResultEventAndRaceDetail(ResultEvent resultEvent, Long raceDetail) {
        List<Event> events = readCollection();
        Iterator<Event> eventIterator = events.iterator();
        while (eventIterator.hasNext()) {
            Event next = eventIterator.next();
            if (!next.getRaceDetailId().equals(raceDetail)||!next.getRaceDetailId().equals(raceDetail)) {
                eventIterator.remove();
            }
        }
        return events;
    }

    @Override
    public List<Event> getAllByResultEvent(ResultEvent resultEvent) {
        List<Event> events = readCollection();
        Iterator<Event> eventIterator = events.iterator();
        while (eventIterator.hasNext()) {
            Event next = eventIterator.next();
            if (!next.getResultEvent().equals(resultEvent)) {
                eventIterator.remove();
            }
        }
        return events;
    }

    public Long next() { return sequence.getAndIncrement(); }

    public AtomicLong getSequence() {
        return sequence;
    }
}
