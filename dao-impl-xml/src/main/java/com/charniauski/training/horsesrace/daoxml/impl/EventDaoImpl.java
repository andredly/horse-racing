package com.charniauski.training.horsesrace.daoxml.impl;


import com.charniauski.training.horsesrace.daoapi.EventDao;
import com.charniauski.training.horsesrace.datamodel.Event;
import com.charniauski.training.horsesrace.datamodel.enums.ResultEvent;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static com.charniauski.training.horsesrace.daoxml.util.SqlBuilder.sqlSelectEntity;
import static java.lang.String.format;

/**
 * Created by Andre on 19.10.2016.
 */
@Repository
public class EventDaoImpl extends AbstractDao<Event,Long> implements EventDao {

    private final AtomicLong sequence=new AtomicLong(0L);
    @Override
    public List<Event> getAllByRaceDetail(Long raceDetail) {
        String sql = format("%s WHERE race_detail_id=%d;", sqlSelectEntity(Event.class), raceDetail);
        return getListEntity(sql,Event.class);
    }

    @Override
    public List<Event> getAllByResultEventAndRaceDetail(ResultEvent resultEvent, Long raceDetail) {
        String sql = format("%s WHERE result_event='%s' AND race_detail_id=%d;", sqlSelectEntity(Event.class),resultEvent, raceDetail);
        return getListEntity(sql,Event.class);
    }

    @Override
    public List<Event> getAllByResultEvent(ResultEvent resultEvent) {
        String sql = format("%s WHERE result_event='%s';", sqlSelectEntity(Event.class),resultEvent);
        return getListEntity(sql,Event.class);
    }

    public Long next() {
        return sequence.incrementAndGet();
    }

    public AtomicLong getSequence() {
        return sequence;
    }
}
