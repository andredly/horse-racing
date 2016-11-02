package com.charniauski.training.horsesrace.daodb.impl;

import com.charniauski.training.horsesrace.daodb.AccountDao;
import com.charniauski.training.horsesrace.datamodel.Account;
import com.charniauski.training.horsesrace.datamodel.RaceCard;
import com.charniauski.training.horsesrace.datamodel.enums.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.charniauski.training.horsesrace.daodb.util.ReflectionUtil.getBean;
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

    @Override
    public Status getStatusByLogin(String login) {
        String sql = format("%s WHERE login='%s';", sqlSelectEntity(Account.class), login);
        Map<String, Object> stringObjectMap;
        Account bean;
        try {
            stringObjectMap = getJdbcTemplate().queryForMap(sql);
            bean = getBean(stringObjectMap, Account.class);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
        return bean.getStatus();
    }

    @Override
    public List<Account> getAllAccountsByStatus(Status status) {
        List<Account> listT = new ArrayList<>();
        String sql = format("%s WHERE status='%s';", sqlSelectEntity(Account.class), status.name());
        List<Map<String, Object>> listMap = getJdbcTemplate().queryForList(sql);
        for (Map<String, Object> map : listMap) {
            Account entity = getBean(map, Account.class);
            listT.add(entity);
        }
        return listT;
    }
}
