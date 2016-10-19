package com.charniauski.training.horsesrace.daodb;

import com.charniauski.training.horsesrace.datamodel.RaceCard;

import java.util.List;

/**
 * Created by Andre on 19.10.2016.
 */
public interface RaceCardDao {

    RaceCard get(Long id);

    void insert(RaceCard entity);

    void update(RaceCard entity);

    void delete(Long id);

    List<RaceCard> getAll();
}
