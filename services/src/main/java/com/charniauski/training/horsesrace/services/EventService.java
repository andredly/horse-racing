package com.charniauski.training.horsesrace.services;

import com.charniauski.training.horsesrace.datamodel.Event;
import com.charniauski.training.horsesrace.datamodel.enums.ResultEvent;

import java.util.List;

/**
 * Created by Andre on 18.10.2016.
 */
public interface EventService extends GenericService<Event,Long> {

    List<Event> getAllByRaceDetail(Long raceDetail);

    List<Event> getAllByResultEvent(ResultEvent resultEvent);

    List<Event> getAllByResultEventAndRaceDetail(ResultEvent resultEvent, Long raceDetail);


}
