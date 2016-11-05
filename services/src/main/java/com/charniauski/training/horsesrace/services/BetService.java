package com.charniauski.training.horsesrace.services;

import com.charniauski.training.horsesrace.datamodel.Account;
import com.charniauski.training.horsesrace.datamodel.Bet;
import com.charniauski.training.horsesrace.datamodel.enums.StatusBet;

import java.util.List;

/**
 * Created by Andre on 18.10.2016.
 */
public interface BetService extends GenericService<Bet,Long> {

    List<Bet> getAllByLogin(String login);

    List<Bet> getAllByLoginAndStatusBet(String login, String statusBet);

    List<Bet> getAllByStatusBet(String statusBet);

    Bet getByAccountAndEvent(String login, Long eventId);

    void updateStatusBetAndCalculate(Long betId, StatusBet statusBet, Double calculate);
}
