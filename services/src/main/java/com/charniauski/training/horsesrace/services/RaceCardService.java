package com.charniauski.training.horsesrace.services;

import com.charniauski.training.horsesrace.datamodel.RaceCard;
import com.charniauski.training.horsesrace.services.wrapper.RaceCardWrapper;
import com.charniauski.training.horsesrace.services.wrapper.RaceDetailWrapper;

import java.util.Date;
import java.util.List;

/**
 * Created by Andre on 18.10.2016.
 */
public interface RaceCardService extends GenericService<RaceCard,Long> {

    List<RaceCard> getAllByRacecourseAfterCurrentDate(Long racecourseId);

    List<RaceCard> getThreeNextAfterCurrentDate(Long racecourseId);

    Date getDateStartByEvent(Long eventId);

    void saveDateFinish(Long raceCardId, Date dateFinish);

    RaceCardWrapper getRaceCardWrapper(Long raceCardId);
}
