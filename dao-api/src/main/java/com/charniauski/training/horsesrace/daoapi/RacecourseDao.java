package com.charniauski.training.horsesrace.daoapi;

import com.charniauski.training.horsesrace.datamodel.Racecourse;

import java.util.List;

/**
 * Created by Andre on 19.10.2016.
 */
public interface RacecourseDao extends GenericDao<Racecourse,Long>{

    List<Racecourse> getAllAfterCurrentDate();

    Racecourse getByName(String name);

}
