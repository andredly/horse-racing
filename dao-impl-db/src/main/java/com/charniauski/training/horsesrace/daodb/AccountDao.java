package com.charniauski.training.horsesrace.daodb;

import com.charniauski.training.horsesrace.datamodel.Account;

/**
 * Created by Andre on 19.10.2016.
 */
public interface AccountDao extends GenericDao<Account, Long>{

    Account getAccountByLogin(String login);

}
