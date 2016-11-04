package com.charniauski.training.horsesrace.daodb.impl;

import com.charniauski.training.horsesrace.daodb.BetDao;
import com.charniauski.training.horsesrace.datamodel.Account;
import com.charniauski.training.horsesrace.datamodel.Bet;
import com.charniauski.training.horsesrace.datamodel.Horse;
import com.charniauski.training.horsesrace.datamodel.Racecourse;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static com.charniauski.training.horsesrace.daodb.util.SqlBuilder.sqlSelectEntity;
import static java.lang.String.format;

/**
 * Created by Andre on 19.10.2016.
 */
@Repository
public class BetDaoImpl extends AbstractDao<Bet,Long> implements BetDao{

    @Override
    public List<Bet> getAllByLogin(String login) {
        String sql = String.format("SELECT * FROM account ac" +
                " LEFT JOIN bet bt ON bt.account_id = ac.id WHERE login='%s';",login);
        return getListEntity(sql,Bet.class);
    }

    @Override
    public List<Bet> getAllByLoginAndStatus(String login, String statusBet) {
        String sql = String.format("SELECT * FROM account ac" +
                " LEFT JOIN bet bt ON bt.account_id = ac.id WHERE login='%s' AND status_bet='%s';",login,statusBet);
        return getListEntity(sql,Bet.class);
    }

    @Override
    public List<Bet> getAllByStatus(String statusBet) {
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


}
