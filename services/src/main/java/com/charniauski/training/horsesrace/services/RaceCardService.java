package com.charniauski.training.horsesrace.services;

import com.charniauski.training.horsesrace.datamodel.RaceCard;
import com.charniauski.training.horsesrace.services.wrapper.RaceCardWrapper;

import java.util.Date;
import java.util.List;

/**
 * Created by Andre on 18.10.2016.
 */
public interface RaceCardService extends GenericService<RaceCard,Long> {

    List<RaceCard> getAllByRacecourseAfterCurrentDate(Long racecourseId);

    Date getDateStartByEvent(Long eventId);

    List<RaceCardWrapper> getAllDataForAllRaceCardAfterCurrentDate(Long racecourseId);

    List<RaceCardWrapper> getAllDataForTreeRaceCardAfterCurrentDate(Long racecourseId);

    RaceCardWrapper getAllDataForRaceCard(Long raceCardId);
}
