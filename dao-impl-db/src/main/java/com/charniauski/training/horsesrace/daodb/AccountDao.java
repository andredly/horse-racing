package com.charniauski.training.horsesrace.daodb;

import com.charniauski.training.horsesrace.datamodel.Account;

import java.util.List;

/**
 * Created by Andre on 19.10.2016.
 */
public interface AccountDao {

    Account get(Long id);

    void insert(Account entity);

    void update(Account entity);

    void delete(Long id);

    List<Account> getAll();
}
