package com.charniauski.training.horsesrace.services.impl;

import com.charniauski.training.horsesrace.daodb.AccountDao;
import com.charniauski.training.horsesrace.daodb.GenericDao;
import com.charniauski.training.horsesrace.datamodel.Account;
import com.charniauski.training.horsesrace.datamodel.Client;
import com.charniauski.training.horsesrace.services.AccountService;
import com.charniauski.training.horsesrace.services.ClientService;
import com.charniauski.training.horsesrace.services.SecurityLevelService;
import com.charniauski.training.horsesrace.services.wrapper.AccountWithClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.Date;

import static com.charniauski.training.horsesrace.datamodel.AccountStatus.CLIENT;

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

    @Inject
    private SecurityLevelService securityLevel;


    @Override
    public GenericDao getGenericDao() {
        return accountDao;
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
        LOGGER.info("Transaction start create Account={}",accountWithClient.getAccount().getLogin());
        Account account = accountWithClient.getAccount();
        Client client=accountWithClient.getClient();
        Long accountId = null;
        if (account.getId()==null){
            account.setSecurityLevelId(securityLevel.getSecurityLevel(CLIENT).getId());
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
}
