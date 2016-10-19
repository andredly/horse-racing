package com.charniauski.training.horsesrace.daodb.impl;

import com.charniauski.training.horsesrace.daodb.AccountDao;
import com.charniauski.training.horsesrace.datamodel.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Andre on 19.10.2016.
 */
@Repository
public class AccountDaoImpl implements AccountDao {
    @Override
    public Account get(Long id) {
        // TODO: 19.10.2016
        return null;
    }

    @Override
    public void insert(Account entity) {
// TODO: 19.10.2016
    }

    @Override
    public void update(Account entity) {
// TODO: 19.10.2016
    }

    @Override
    public void delete(Long id) {
// TODO: 19.10.2016
    }

    @Override
    public List<Account> getAll() {
        // TODO: 19.10.2016
        return null;
    }
}
