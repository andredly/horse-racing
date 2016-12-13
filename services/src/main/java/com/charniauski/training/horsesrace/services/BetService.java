package com.charniauski.training.horsesrace.services;

import com.charniauski.training.horsesrace.datamodel.Bet;
import com.charniauski.training.horsesrace.datamodel.enums.StatusBet;
import com.charniauski.training.horsesrace.services.wrapper.BetWrapper;

import java.util.List;

/**
 * Created by Andre on 18.10.2016.
 */
public interface BetService extends GenericService<Bet,Long> {

    List<Bet> getAllByLogin(String login);

    List<Bet> getAllByLoginAndStatusBet(String login, StatusBet statusBet);

    List<Bet> getAllByStatusBet(StatusBet statusBet);

    Bet getByAccountAndEvent(String login, Long eventId);

    BetWrapper getAllDataForBet(Long id);

    List<BetWrapper> getAllDataByLogin(String login);
}
