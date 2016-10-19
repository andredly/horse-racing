package com.charniauski.training.horsesrace.daodb;

import com.charniauski.training.horsesrace.datamodel.Bet;

import java.util.List;

/**
 * Created by Andre on 19.10.2016.
 */
public interface BetDao {

    Bet get(Long id);

    void insert(Bet entity);

    void update(Bet entity);

    void delete(Long id);

    List<Bet> getAll();
}
