package com.charniauski.training.horsesrace.daoxml.impl;


import com.charniauski.training.horsesrace.daoapi.EventDao;
import com.charniauski.training.horsesrace.datamodel.Event;
import com.charniauski.training.horsesrace.datamodel.enums.ResultEvent;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * Created by Andre on 19.10.2016.
 */
@Repository
public class EventDaoImpl extends AbstractDao<Event,Long> implements EventDao {

    private final AtomicLong sequence=new AtomicLong(1L);
    @Override
    public List<Event> getAllByRaceDetail(Long raceDetail) {
        return readCollection().stream().filter(event->event.getRaceDetailId().equals(raceDetail)).collect(Collectors.toList());
    }

    @Override
    public List<Event> getAllByResultEventAndRaceDetail(ResultEvent resultEvent, Long raceDetail) {
        return readCollection().stream().filter(event->event.getResultEvent().equals(resultEvent)
                &&event.getRaceDetailId().equals(raceDetail)).collect(Collectors.toList());
    }

    @Override
    public List<Event> getAllByResultEvent(ResultEvent resultEvent) {
        return readCollection().stream().filter(event->event.getResultEvent().equals(resultEvent)).collect(Collectors.toList());
    }

    public Long next() { return sequence.getAndIncrement(); }

    public AtomicLong getSequence() {
        return sequence;
    }
}
