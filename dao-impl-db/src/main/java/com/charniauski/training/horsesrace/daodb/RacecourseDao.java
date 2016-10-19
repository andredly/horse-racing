package com.charniauski.training.horsesrace.daodb;

import com.charniauski.training.horsesrace.datamodel.Racecourse;

import java.util.List;

/**
 * Created by Andre on 19.10.2016.
 */
public interface RacecourseDao {

    Racecourse get(Long id);

    void insert(Racecourse entity);

    void update(Racecourse entity);

    void delete(Long id);

    List<Racecourse> getAll();
}
