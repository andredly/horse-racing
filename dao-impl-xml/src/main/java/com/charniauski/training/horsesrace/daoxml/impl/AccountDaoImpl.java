package com.charniauski.training.horsesrace.daoxml.impl;

import com.charniauski.training.horsesrace.daoapi.AccountDao;
import com.charniauski.training.horsesrace.datamodel.Account;
import com.charniauski.training.horsesrace.datamodel.enums.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by Andre on 19.10.2016.
 */
@Repository
public class AccountDaoImpl extends AbstractDao<Account, Long> implements AccountDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountDaoImpl.class);

    private final AtomicLong sequence = new AtomicLong(1L);

    @Override
    public Account getByLogin(String login) {
        return readCollection().stream().filter(ac -> ac.getLogin().equals(login)).findFirst().orElse(null);
    }


    @Override
    public List<Account> getAllByStatus(Status status) {
        return readCollection().stream().filter(ac -> ac.getStatus().equals(status)).collect(Collectors.toList());
    }

    public Long next() {
        return sequence.getAndIncrement();
    }

    public AtomicLong getSequence() {
        return sequence;
    }
}
