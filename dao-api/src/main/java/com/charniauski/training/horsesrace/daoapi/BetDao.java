package com.charniauski.training.horsesrace.daoapi;

import com.charniauski.training.horsesrace.datamodel.Bet;
import com.charniauski.training.horsesrace.datamodel.enums.StatusBet;

import java.util.List;

/**
 * Created by Andre on 19.10.2016.
 */
public interface BetDao extends GenericDao<Bet, Long>{

    List<Bet> getAllByLogin(String login);

    List<Bet> getAllByLoginAndStatusBet(String login, StatusBet statusBet);

    List<Bet> getAllByStatusBet(StatusBet statusBet);

    Bet getByAccountAndEvent(String login, Long eventId);
}
