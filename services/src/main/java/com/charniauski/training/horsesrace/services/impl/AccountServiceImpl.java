package com.charniauski.training.horsesrace.services.impl;

import com.charniauski.training.horsesrace.daodb.AccountDao;
import com.charniauski.training.horsesrace.daodb.GenericDao;
import com.charniauski.training.horsesrace.datamodel.Account;
import com.charniauski.training.horsesrace.datamodel.Client;
import com.charniauski.training.horsesrace.services.AccountService;
import com.charniauski.training.horsesrace.services.ClientService;
import com.charniauski.training.horsesrace.services.exception.NoSuchEntityException;
import com.charniauski.training.horsesrace.services.wrapper.AccountWithClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

/**
 * Created by Andre on 19.10.2016.
 */
@Service
public class AccountServiceImpl extends AbstractService<Account,Long> implements AccountService {


    @Inject
    private AccountDao accountDao;

    @Inject
    private ClientService clientService;


    @Override
    public GenericDao getGenericDao() {
        return accountDao;
    }

    @Override
    public Long save(Account entity)
    {
       return accountDao.insert(entity);
    }

    @Override
    public Account getAccountByLogin(String login) {
        return accountDao.getAccountByLogin(login);
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
        Account account = accountWithClient.getAccount();
        Client client=accountWithClient.getClient();
        Long accountId = null;
        if (account.getId()==null){
            accountId = save(account);
            client.setId(accountId);
            clientService.save(client);
        }else if (account.getId()!=null){
            accountId = save(account);
            client.setId(accountId);
            clientService.update(client);
        }
        return accountId;
    }
}
