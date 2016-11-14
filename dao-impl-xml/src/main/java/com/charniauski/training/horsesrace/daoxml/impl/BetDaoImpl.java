package com.charniauski.training.horsesrace.daoxml.impl;

import com.charniauski.training.horsesrace.daoapi.BetDao;
import com.charniauski.training.horsesrace.datamodel.Account;
import com.charniauski.training.horsesrace.datamodel.Bet;
import com.charniauski.training.horsesrace.datamodel.enums.StatusBet;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Andre on 19.10.2016.
 */
@Repository
public class BetDaoImpl extends AbstractDao<Bet,Long> implements BetDao {
    private final AtomicLong sequence=new AtomicLong(0L);

    @Override
    public List<Bet> getAllByLogin(String login) {
        Account account = getAccount(login);
        List<Bet> bets = readCollection();
        Iterator<Bet> betIterator = bets.iterator();
        while (betIterator.hasNext()) {
            Bet next = betIterator.next();
            if (!next.getAccountId().equals(account.getId())) {
                betIterator.remove();
            }
        }
        return bets;
    }


    @Override
    public List<Bet> getAllByLoginAndStatusBet(String login, StatusBet statusBet) {
        Account account = getAccount(login);
        List<Bet> bets = readCollection();
        Iterator<Bet> betIterator = bets.iterator();
        while (betIterator.hasNext()) {
            Bet next = betIterator.next();
            if (!next.getStatusBet().equals(statusBet)||!next.getAccountId().equals(account.getId())) {
                betIterator.remove();
            }
        }
        return bets;
    }

    @Override
    public List<Bet> getAllByStatusBet(StatusBet statusBet) {
        List<Bet> bets = readCollection();
        Iterator<Bet> betIterator = bets.iterator();
        while (betIterator.hasNext()) {
            Bet next = betIterator.next();
            if (!next.getStatusBet().equals(statusBet)) {
                betIterator.remove();
            }
        }
        return bets;
    }

    @Override
    public Bet getByAccountAndEvent(String login, Long eventId) {
        Account account = getAccount(login);
        for (Bet bet:readCollection())
            if (bet.getEventId().equals(eventId)&&bet.getAccountId().equals(account.getId())) {
               return bet;
            }
        return null;
    }

    private Account getAccount(String login) {
        File fileAccount = new File(getBasePath() + "/" + Account.class.getSimpleName() + ".xml");
        getXstream().alias(Account.class.getSimpleName(), Account.class);
        List<Account> listAccount = new ArrayList<>((List<Account>) getXstream().fromXML(fileAccount));
        Account account = null;
        for (Account ac:listAccount){
            if (ac.getLogin().equals(login)){account=ac;}
        }
        return account;
    }

    public Long next() {
        return sequence.incrementAndGet();
    }

    public AtomicLong getSequence() {
        return sequence;
    }


}
