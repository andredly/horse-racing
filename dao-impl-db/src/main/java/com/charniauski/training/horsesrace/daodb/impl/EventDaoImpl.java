package com.charniauski.training.horsesrace.daodb.impl;

import com.charniauski.training.horsesrace.daodb.EventDao;
import com.charniauski.training.horsesrace.datamodel.Bet;
import com.charniauski.training.horsesrace.datamodel.Event;
import com.charniauski.training.horsesrace.datamodel.Horse;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.charniauski.training.horsesrace.daodb.util.SqlBuilder.sqlSelectEntity;
import static java.lang.String.format;

/**
 * Created by Andre on 19.10.2016.
 */
@Repository
public class EventDaoImpl extends AbstractDao<Event,Long> implements EventDao{

    @Override
    public List<Event> getAllByRaceDetail(Long raceDetail) {
        String sql = format("%s WHERE race_detail_id=%d;", sqlSelectEntity(Event.class), raceDetail);
        return getListEntity(sql,Event.class);
    }

    @Override
    public List<Event> getAllByResultEventAndRaceDetail(String resultEvent, Long raceDetail) {
        String sql = format("%s WHERE result_event='%s' AND race_detail_id=%d;", sqlSelectEntity(Event.class),resultEvent, raceDetail);
        return getListEntity(sql,Event.class);
    }

    @Override
    public List<Event> getAllByResultEvent(String resultEvent) {
        String sql = format("%s WHERE result_event='%s';", sqlSelectEntity(Event.class),resultEvent);
        return getListEntity(sql,Event.class);
    }
}
