package com.charniauski.training.horsesrace.services.impl;

import com.charniauski.training.horsesrace.daodb.AccountDao;
import com.charniauski.training.horsesrace.daodb.GenericDao;
import com.charniauski.training.horsesrace.datamodel.Account;
import com.charniauski.training.horsesrace.datamodel.Client;
import com.charniauski.training.horsesrace.datamodel.enums.Status;
import com.charniauski.training.horsesrace.services.AccountService;
import com.charniauski.training.horsesrace.services.ClientService;
import com.charniauski.training.horsesrace.services.wrapper.AccountWithClient;
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
public class AccountServiceImpl extends AbstractService<Account,Long> implements AccountService {

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
        Account account=get(accountId);
        Client client=clientService.get(accountId);
        AccountWithClient accountWithClient=new AccountWithClient();
        accountWithClient.setAccount(account);
        accountWithClient.setClient(client);
        return accountWithClient;
    }


    @Transactional
    @Override
    public Long save(AccountWithClient accountWithClient) {
        LOGGER.info("Transaction start create Account={}",accountWithClient.getAccount().getLogin());
        Account account = accountWithClient.getAccount();
        Client client=accountWithClient.getClient();
        Long accountId = null;
        if (account.getId()==null){
            account.setStatus(Status.CLIENT);
            account.setBalance(0.0);
            client.setDate(new Date());
            accountId = save(account);
            client.setId(accountId);
            clientService.save(client);
        }else if (account.getId()!=null){
            accountId = save(account);
            client.setId(accountId);
            clientService.update(client);
        }
        LOGGER.info("Transaction end create Account={}",accountWithClient.getAccount().getLogin());
        return accountId;
    }

    @Override
    public Long save(Account account, Client client) {
        AccountWithClient accountWithClient=new AccountWithClient();
        accountWithClient.setAccount(account);
        accountWithClient.setClient(client);
        return save(accountWithClient);
    }
}
