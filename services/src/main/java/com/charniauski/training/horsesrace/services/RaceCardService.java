package com.charniauski.training.horsesrace.services;

import com.charniauski.training.horsesrace.datamodel.RaceCard;
import com.charniauski.training.horsesrace.datamodel.Racecourse;

import java.util.List;

/**
 * Created by Andre on 18.10.2016.
 */
public interface RaceCardService extends GenericService<RaceCard,Long> {

    List<RaceCard> getAllAfterCurrentDate(Long racecourseId);

    List<RaceCard> getThreeNextAfterCurrentDate();

    List<RaceCard> getAllAfterCurrentDate();
}
