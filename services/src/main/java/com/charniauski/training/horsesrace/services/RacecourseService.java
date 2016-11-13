package com.charniauski.training.horsesrace.services;

import com.charniauski.training.horsesrace.datamodel.Racecourse;
import com.charniauski.training.horsesrace.services.wrapper.RacecourseWrapper;

import java.util.List;

/**
 * Created by Andre on 18.10.2016.
 */
public interface RacecourseService extends GenericService<Racecourse,Long> {

    List<Racecourse> getAllAfterCurrentDate();

    Racecourse getByName(String nameRacecourse);

    RacecourseWrapper getRacecourseWrapper(Long racecourseId);

}
