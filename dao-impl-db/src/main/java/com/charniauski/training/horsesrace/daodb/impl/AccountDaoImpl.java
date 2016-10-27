package com.charniauski.training.horsesrace.daodb.impl;

import com.charniauski.training.horsesrace.daodb.AccountDao;
import com.charniauski.training.horsesrace.datamodel.Account;
import org.springframework.stereotype.Repository;

import static com.charniauski.training.horsesrace.daodb.util.SqlUtil.sqlInsertOrUpdateEntity;

/**
 * Created by Andre on 19.10.2016.
 */
@Repository
public class AccountDaoImpl extends AbstractDao<Account,Long> implements AccountDao{
    public AccountDaoImpl() {
        super(Account.class);
    }


    @Override
    public void update(Account entity) {
        String sql = sqlInsertOrUpdateEntity(entity, false);
//        sql = sql + " id=" + entity.getId();
        System.out.println(sql);
        int update = getJdbcTemplate().update(sql);
        sql=sqlInsertOrUpdateEntity(entity,true);

        if(update==0){getJdbcTemplate().update(sql);
        System.out.println(sql);}
    }
}
