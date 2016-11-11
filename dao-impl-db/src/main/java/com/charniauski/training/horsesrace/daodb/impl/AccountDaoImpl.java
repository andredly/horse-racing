package com.charniauski.training.horsesrace.daodb.impl;

import com.charniauski.training.horsesrace.daodb.AccountDao;
import com.charniauski.training.horsesrace.datamodel.Account;
import com.charniauski.training.horsesrace.datamodel.enums.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.charniauski.training.horsesrace.daodb.util.SqlBuilder.sqlSelectEntity;
import static java.lang.String.format;

/**
 * Created by Andre on 19.10.2016.
 */
@Repository
public class AccountDaoImpl extends AbstractDao<Account, Long> implements AccountDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountDaoImpl.class);

    @Override
    public Account getByLogin(String login) {
        String sql = format("%s WHERE login='%s';", sqlSelectEntity(Account.class), login);
        return getEntity(sql,Account.class);
    }

    @Override
    public Status getStatusByLogin(String login) {
        String sql = format("%s WHERE login='%s';", sqlSelectEntity(Account.class), login);
        return getEntity(sql,Account.class).getStatus();
    }

    @Override
    public List<Account> getAllByStatus(Status status) {
        String sql = format("%s WHERE status='%s';", sqlSelectEntity(Account.class), status.name());
        return getListEntity(sql,Account.class);
    }
}
