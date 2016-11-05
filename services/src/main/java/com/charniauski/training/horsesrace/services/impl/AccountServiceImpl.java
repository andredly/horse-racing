package com.charniauski.training.horsesrace.services.impl;

import com.charniauski.training.horsesrace.daodb.AccountDao;
import com.charniauski.training.horsesrace.daodb.GenericDao;
import com.charniauski.training.horsesrace.datamodel.Account;
import com.charniauski.training.horsesrace.datamodel.Bet;
import com.charniauski.training.horsesrace.datamodel.Client;
import com.charniauski.training.horsesrace.datamodel.enums.Status;
import com.charniauski.training.horsesrace.services.AccountService;
import com.charniauski.training.horsesrace.services.BetService;
import com.charniauski.training.horsesrace.services.ClientService;
import com.charniauski.training.horsesrace.services.wrapper.AccountWrapper;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import static com.charniauski.training.horsesrace.datamodel.enums.Status.*;


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

    @Inject
    private BetService betService;

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
    public AccountWrapper getAccountWrapper(String login) {
        Account account = getByLogin(login);
        Client client = clientService.get(account.getId());
        List<Bet> bets = betService.getAllByLogin(account.getLogin());
        AccountWrapper accountWrapper = new AccountWrapper();
        accountWrapper.setAccount(account);
        accountWrapper.setBets(bets);
        accountWrapper.setClient(client);
        return accountWrapper;
    }


    @Transactional
    @Override
    public Long save(Account account, Client client) {
        Long id = save(account);
        client.setId(id);
        clientService.save(client);
        return id;
    }

    @Transactional
    @Override
    public Long save(Account account) throws NullPointerException, IllegalArgumentException {
        accountDataValidate(account);
        Long accountId;
        if (account.getId() == null) {
            Account oldAccount = accountDao.getByLogin(account.getLogin());
            if (oldAccount != null)
                throw new IllegalArgumentException("Login " + account.getLogin() + " already exists");
            account.setDateRegisterAccount(new Timestamp(new Date().getTime()));
            account.setStatus(CLIENT);
            account.setBalance(0.0);
            accountId = accountDao.insert(account);
            LOGGER.info("Create Account={}", account.getLogin());
        } else {
            accountDao.update(account);
            accountId = account.getId();
            LOGGER.info("Update Account={}", account.getLogin());
        }
        return accountId;
    }

    private void accountDataValidate(Account account) {
        Validate.notNull(account.getLogin(), "Arguments Login may not by null");
        Validate.notNull(account.getPassword(), "Arguments Password may not by null");
        Validate.notNull(account.getEmail(), "Arguments Email may not by null");
        Validate.notEmpty(account.getLogin());
        Validate.notEmpty(account.getPassword());
        Validate.notEmpty(account.getEmail());
    }
}
