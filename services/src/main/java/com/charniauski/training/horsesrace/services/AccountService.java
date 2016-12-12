package com.charniauski.training.horsesrace.services;

import com.charniauski.training.horsesrace.datamodel.Account;
import com.charniauski.training.horsesrace.datamodel.enums.Status;
import com.charniauski.training.horsesrace.services.wrapper.AccountWrapper;

import java.util.List;

/**
 * Created by Andre on 18.10.2016.
 */
public interface AccountService extends GenericService<Account,Long> {

    Account getByLogin(String login);

    Status getStatusByLogin(String login);

    List<Account> getAllByStatus(Status status);

    AccountWrapper getAllDataForAccount(String login);

    List<AccountWrapper> getAllDataForAllAccount();

    void fakeDelete(Long accountId);
}
