package com.charniauski.training.horsesrace.daodb;

import com.charniauski.training.horsesrace.datamodel.Bet;

import java.util.List;

/**
 * Created by Andre on 19.10.2016.
 */
public interface BetDao extends GenericDao<Bet, Long>{

    List<Bet> getAllByLogin(String login);

    List<Bet> getAllByLoginAndStatusBet(String login, String statusBet);

    List<Bet> getAllByStatusBet(String statusBet);

    Bet getByAccountAndEvent(String login, Long eventId);
}
