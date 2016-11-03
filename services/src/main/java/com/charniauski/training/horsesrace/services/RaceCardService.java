package com.charniauski.training.horsesrace.services;

import com.charniauski.training.horsesrace.datamodel.RaceCard;

import java.util.Date;
import java.util.List;

/**
 * Created by Andre on 18.10.2016.
 */
public interface RaceCardService extends GenericService<RaceCard,Long> {

    List<RaceCard> getAllByRacecourseAfterCurrentDate(Long racecourseId);

    List<RaceCard> getThreeNextAfterCurrentDate();

    List<RaceCard> getAllAfterCurrentDate();

    Date getDateStart(Long raceCardId);

    Date getDateFinish(Long raceCardId);
}
