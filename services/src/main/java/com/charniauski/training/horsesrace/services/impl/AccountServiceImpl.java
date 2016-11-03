package com.charniauski.training.horsesrace.services.impl;

import com.charniauski.training.horsesrace.daodb.AccountDao;
import com.charniauski.training.horsesrace.daodb.GenericDao;
import com.charniauski.training.horsesrace.datamodel.Account;
import com.charniauski.training.horsesrace.datamodel.Client;
import com.charniauski.training.horsesrace.datamodel.enums.Status;
import com.charniauski.training.horsesrace.services.AccountService;
import com.charniauski.training.horsesrace.services.ClientService;
import com.charniauski.training.horsesrace.services.wrapper.AccountWithClient;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;


/**
 * Created by Andre on 19.10.2016.
 */
@Service
public class AccountServiceImpl extends AbstractService<Account, Long> implements AccountService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Inject
    private AccountDao accountDao;

    @Inject
    private ClientService clientService;

    @Override
    public GenericDao getGenericDao() {
        return accountDao;
    }


    @Override
    public Account getByLogin(String login) {
        return accountDao.getByLogin(login);
    }

    @Override
    public Status getStatusByLogin(String login) {
        return accountDao.getStatusByLogin(login);
    }

    @Override
    public List<Account> getAllByStatus(Status status) {
        return accountDao.getAllAccountsByStatus(status);
    }

    @Override
    public AccountWithClient getAccountWithClient(Long accountId) {
        Account account = get(accountId);
        Client client = clientService.get(accountId);
        AccountWithClient accountWithClient = new AccountWithClient();
        accountWithClient.setAccount(account);
        accountWithClient.setClient(client);
        return accountWithClient;
    }


    @Transactional
    @Override
    public Long save(AccountWithClient accountWithClient) {
        //// TODO: 03.11.2016 update not found
        LOGGER.info("Save start create Account={}", accountWithClient.getAccount().getLogin());
        Account account = accountWithClient.getAccount();
        Client client = accountWithClient.getClient();
        Long accountId;
        if (account.getId() == null) {
            account.setStatus(Status.CLIENT);
            account.setBalance(0.0);
            client.setDate(new Date());
            accountId = save(account);
            client.setId(accountId);
            clientService.save(client);
        } else {
            accountId = save(account);
            client.setId(accountId);
//            clientService.update(client);
        }
        return accountId;
    }

    @Transactional
    @Override
    public Long save(Account account, Client client) {
        // TODO: 03.11.2016
        AccountWithClient accountWithClient = new AccountWithClient();
        accountWithClient.setAccount(account);
        accountWithClient.setClient(client);
        return save(accountWithClient);
    }

    @Transactional
    @Override
    public Long save(Account account) throws NullPointerException, IllegalArgumentException {
        LOGGER.info("Account start create Account={}", account.getLogin());
        Validate.notNull(account.getLogin(),"Arguments Login may not by null");
        Validate.notNull(account.getStatus(),"Arguments Status may not by null");
        Validate.notNull(account.getPassword(),"Arguments Password may not by null");
        Validate.notNull(account.getEmail(),"Arguments Email may not by null");
        Long accountId;
        if (account.getId() == null) {
            Account oldAccount = accountDao.getByLogin(account.getLogin());
            if (oldAccount!=null)throw new IllegalArgumentException("Login "+ account.getLogin()+" already exists");
            account.setBalance(0.0);
            accountId = accountDao.insert(account);
        } else {
            accountDao.update(account);
            accountId=account.getId();
        }
        return accountId;
    }
}
