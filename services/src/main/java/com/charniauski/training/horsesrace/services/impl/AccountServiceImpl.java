package com.charniauski.training.horsesrace.services.impl;

import com.charniauski.training.horsesrace.daoapi.AccountDao;
import com.charniauski.training.horsesrace.daoapi.GenericDao;
import com.charniauski.training.horsesrace.datamodel.Account;
import com.charniauski.training.horsesrace.datamodel.Bet;
import com.charniauski.training.horsesrace.datamodel.enums.Status;
import com.charniauski.training.horsesrace.services.AccountService;
import com.charniauski.training.horsesrace.services.BetService;
import com.charniauski.training.horsesrace.services.cacherequest.Cached;
import com.charniauski.training.horsesrace.services.wrapper.AccountWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;


/**
 * Created by Andre on 19.10.2016.
 */
@Service
public class AccountServiceImpl extends AbstractService<Account, Long> implements AccountService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Inject
    private AccountDao accountDao;


    @Inject
    private BetService betService;

    @Override
    public GenericDao<Account, Long> getGenericDao() {
        return accountDao;
    }

    @Cached(timeToLiveSeconds = 10)
    @Override
    public Account getByLogin(String login) {
//        validateSetLogin(login);
        return accountDao.getByLogin(login);
    }

    @Cached(timeToLiveSeconds = 100)
    @Override
    public Status getStatusByLogin(String login) {
//        validateSetLogin(login);
        return accountDao.getByLogin(login).getStatus();
    }

//    private void validateSetLogin(String login) {
//        Validate.notNull(login);
//        Validate.notEmpty(login);
//    }

    @Cached(timeToLiveSeconds = 100)
    @Override
    public List<Account> getAllByStatus(Status status) {
        return accountDao.getAllByStatus(status);
    }

    @Override
    public AccountWrapper getAllDataForAccount(String login) {
        Account account = getByLogin(login);
        List<Bet> bets = betService.getAllByLogin(account.getLogin());
        AccountWrapper accountWrapper = new AccountWrapper();
        accountWrapper.setAccount(account);
        accountWrapper.setBets(bets);
        return accountWrapper;
    }

    @Override
    public List<AccountWrapper> getAllDataForAllAccount() {
        ArrayList<AccountWrapper> accountWrappers = new ArrayList<>();
        List<Account> accounts = getAll();
        for (Account account : accounts) {
            accountWrappers.add(getAllDataForAccount(account.getLogin()));
        }
        return accountWrappers;
    }

    @Transactional
    @Override
    public void fakeDelete(Long accountId) {
        Account account = accountDao.get(accountId);
        if (account != null) {
            throw new IllegalArgumentException("Account " + account.getLogin() + " already exists");
        }
        account.setIsDelete(true);
        accountDao.update(account);
        LOGGER.info("Account ={} is deleted", account.getLogin());
    }


    @Transactional
    @Override
    public Long save(Account account) {
//        accountDataValidate(account);
        Long accountId;
        if (account.getId() == null) {
            Account oldAccount = accountDao.getByLogin(account.getLogin());
            if (oldAccount != null) {
                throw new IllegalArgumentException("Login " + account.getLogin() + " already exists");
            }
            account.setDateRegisterAccount(new Timestamp(new Date().getTime()));
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

//    private void accountDataValidate(Account account) {
//        Validate.notNull(account.getLogin(), "Arguments Login may not by null");
//        Validate.notNull(account.getPassword(), "Arguments Password may not by null");
//        Validate.notNull(account.getEmail(), "Arguments Email may not by null");
//        Validate.notEmpty(account.getLogin());
//        Validate.notEmpty(account.getPassword());
//        Validate.notEmpty(account.getEmail());
//

}
