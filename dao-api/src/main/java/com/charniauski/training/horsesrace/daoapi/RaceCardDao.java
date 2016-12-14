package com.charniauski.training.horsesrace.daoapi;

import com.charniauski.training.horsesrace.datamodel.RaceCard;

import java.util.Date;
import java.util.List;

/**
 * Created by Andre on 19.10.2016.
 */
public interface RaceCardDao extends GenericDao<RaceCard, Long>{

    List<RaceCard> getAllByRacecourseAfterCurrentDate(Long racecourseId);

    RaceCard getByEvent(Long eventId);

    List<RaceCard> getAllForIntervalTime(Date firstDate, Date lastDate );

}
