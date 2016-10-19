package com.charniauski.training.horsesrace.daodb;

import com.charniauski.training.horsesrace.datamodel.RaceDetail;

import java.util.List;

/**
 * Created by Andre on 19.10.2016.
 */
public interface RaceDetailDao {

    RaceDetail get(Long id);

    void insert(RaceDetail entity);

    void update(RaceDetail entity);

    void delete(Long id);

    List<RaceDetail> getAll();
}
