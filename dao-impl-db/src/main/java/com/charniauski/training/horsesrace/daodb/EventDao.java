package com.charniauski.training.horsesrace.daodb;

import com.charniauski.training.horsesrace.datamodel.Event;

import java.util.List;

/**
 * Created by Andre on 19.10.2016.
 */
public interface EventDao extends GenericDao<Event, Long>{
    List<Event> getAllByRaceDetail(Long raceDetail);

}
