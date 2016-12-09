package com.charniauski.training.horsesrace.daoxml.impl;

import com.charniauski.training.horsesrace.daoapi.BetDao;
import com.charniauski.training.horsesrace.datamodel.Account;
import com.charniauski.training.horsesrace.datamodel.Bet;
import com.charniauski.training.horsesrace.datamodel.enums.StatusBet;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * Created by Andre on 19.10.2016.
 */
@Repository
public class BetDaoImpl extends AbstractDao<Bet,Long> implements BetDao {
    private final AtomicLong sequence=new AtomicLong(1L);

    @Override
    public List<Bet> getAllByLogin(String login) {
        Account account = getAccount(login);
        return readCollection().stream().filter(bt->bt.getAccountId().equals(account.getId()))
                .collect(Collectors.toList());
    }


    @Override
    public List<Bet> getAllByLoginAndStatusBet(String login, StatusBet statusBet) {
        Account account = getAccount(login);
        return readCollection().stream().filter(bt->bt.getAccountId().equals(account.getId())
                &&bt.getStatusBet().equals(statusBet)).collect(Collectors.toList());
    }

    @Override
    public List<Bet> getAllByStatusBet(StatusBet statusBet) {
        return readCollection().stream().filter(bt->bt.getStatusBet().equals(statusBet))
                .collect(Collectors.toList());
    }

    @Override
    public Bet getByAccountAndEvent(String login, Long eventId) {
        Account account = getAccount(login);
        return readCollection().stream().filter(bet -> bet.getEventId().equals(eventId)
            &&bet.getAccountId().equals(account.getId())).findFirst().orElse(null);
    }

    @SuppressWarnings("unchecked")
    private Account getAccount(String login) {
        File fileAccount = new File(String.format("%s/%s.xml",getBasePath(),Account.class.getSimpleName())) ;
        getXstream().alias(Account.class.getSimpleName(), Account.class);
        List<Account> listAccount = new ArrayList<>((List<Account>) getXstream().fromXML(fileAccount));
        return listAccount.stream().filter(ac -> ac.getLogin().equals(login)).findFirst().orElse(null);
    }

    public Long next() { return sequence.getAndIncrement(); }

    public AtomicLong getSequence() {
        return sequence;
    }


}
