package com.charniauski.training.horsesrace.services;

import com.charniauski.training.horsesrace.datamodel.Account;
import com.charniauski.training.horsesrace.services.exception.NoSuchEntityException;
import com.charniauski.training.horsesrace.services.wrapper.AccountWithClient;

/**
 * Created by Andre on 18.10.2016.
 */
public interface AccountService extends GenericService<Account,Long> {

    Account getAccountByLogin(String login);

    AccountWithClient getAccountWithClient(Long accountId);

    Long save(AccountWithClient accountWithClient);
}
