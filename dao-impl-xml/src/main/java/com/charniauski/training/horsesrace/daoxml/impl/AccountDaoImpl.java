package com.charniauski.training.horsesrace.daoxml.impl;

import com.charniauski.training.horsesrace.daoapi.AccountDao;
import com.charniauski.training.horsesrace.datamodel.Account;
import com.charniauski.training.horsesrace.datamodel.enums.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Andre on 19.10.2016.
 */
@Repository
public class AccountDaoImpl extends AbstractDao<Account, Long> implements AccountDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountDaoImpl.class);

    private final AtomicLong sequence=new AtomicLong(0L);

    @Override
    public Account getByLogin(String login) {
        List<Account> accounts = readCollection();
        for (Account account:accounts){
            if (account.getLogin().equals(login)) {
                return account;}
        };
        return null;
    }


    @Override
    public List<Account> getAllByStatus(Status status) {
        List<Account> accounts = readCollection();
        Iterator<Account> iterator = accounts.iterator();
        while (iterator.hasNext()){
            if (!iterator.next().getStatus().equals(status)) {iterator.remove();}
        }
        return accounts;
    }

    public Long next() { return sequence.incrementAndGet(); }

    public AtomicLong getSequence() {
        return sequence;
    }
}
