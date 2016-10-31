package com.charniauski.training.horsesrace.daodb.impl;

import com.charniauski.training.horsesrace.daodb.AccountDao;
import com.charniauski.training.horsesrace.datamodel.Account;
import com.charniauski.training.horsesrace.datamodel.SecurityLevel;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import java.util.Map;

import static com.charniauski.training.horsesrace.daodb.util.ReflectionUtil.getBean;
import static com.charniauski.training.horsesrace.daodb.util.SqlBuilder.sqlSelectEntity;
import static java.lang.String.format;

/**
 * Created by Andre on 19.10.2016.
 */
@Repository
public class AccountDaoImpl extends AbstractDao<Account, Long> implements AccountDao {

    @Override
    public Account getAccountByLogin(String login) {
        String sql = format("%s WHERE login='%s';", sqlSelectEntity(Account.class), login);
        Map<String, Object> stringObjectMap;
        Account bean;
        try {
            stringObjectMap = getJdbcTemplate().queryForMap(sql);
            bean = getBean(stringObjectMap, Account.class);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
        return bean;
    }
}
