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
        File fileAccount = new File(getBasePath() + "/" + Account.class.getSimpleName() + ".xml");
        getXstream().alias(Account.class.getSimpleName(), Account.class);
        List<Account> listAccount = new ArrayList<>((List<Account>) getXstream().fromXML(fileAccount));
        Account account = null;
        for (Account ac:listAccount){
            if (ac.getLogin().equals(login)){account=ac;}
        }
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
        String sql = String.format("SELECT * FROM account ac" +
                " LEFT JOIN bet bt ON bt.account_id = ac.id WHERE login='%s' AND status_bet='%s';",login,statusBet);
        return getListEntity(sql,Bet.class);
    }

    @Override
    public List<Bet> getAllByStatusBet(StatusBet statusBet) {
        String sql = String.format("SELECT * FROM account ac" +
                " LEFT JOIN bet bt ON bt.account_id = ac.id WHERE status_bet='%s';",statusBet);
        return getListEntity(sql,Bet.class);
    }

    @Override
    public Bet getByAccountAndEvent(String login, Long eventId) {
        String sql = String.format("SELECT * FROM account ac" +
                " LEFT JOIN bet bt ON bt.account_id = ac.id WHERE login='%s' AND event_id=%d;",login,eventId);
        return getEntity(sql,Bet.class);
    }
    public Long next() {
        return sequence.incrementAndGet();
    }

    public AtomicLong getSequence() {
        return sequence;
    }


}
