package com.charniauski.training.horsesrace.daoapi;

import com.charniauski.training.horsesrace.datamodel.Event;
import com.charniauski.training.horsesrace.datamodel.enums.ResultEvent;

import java.util.List;

/**
 * Created by Andre on 19.10.2016.
 */
public interface EventDao extends GenericDao<Event, Long>{
    List<Event> getAllByRaceDetail(Long raceDetail);

    List<Event> getAllByResultEventAndRaceDetail(ResultEvent resultEvent, Long raceDetail);

    List<Event> getAllByResultEvent(ResultEvent resultEvent);

}
