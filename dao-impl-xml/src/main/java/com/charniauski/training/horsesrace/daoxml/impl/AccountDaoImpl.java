package com.charniauski.training.horsesrace.daoxml.impl;

import com.charniauski.training.horsesrace.daoapi.AccountDao;
import com.charniauski.training.horsesrace.datamodel.Account;
import com.charniauski.training.horsesrace.datamodel.enums.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


import static com.charniauski.training.horsesrace.daoxml.util.SqlBuilder.sqlSelectEntity;
import static java.lang.String.format;

/**
 * Created by Andre on 19.10.2016.
 */
@Repository
public class AccountDaoImpl extends AbstractDao<Account, Long> implements AccountDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountDaoImpl.class);

    private final AtomicLong sequence=new AtomicLong(0L);

//    public void initSequence(){
//        List<Account> accounts = readCollection();
//        Long maxId=0L;
//        if (!accounts.isEmpty()) {
//            for (Account account : accounts) {
//                maxId=Math.max(maxId,account.getId());
//            }
//        }
//       LOGGER.info(maxId.toString());
//        sequence.set(maxId);
//    }



    @Override
    public Account getByLogin(String login) {
        List<Account> accounts = readCollection();
        for (Account account:accounts){
            if (account.getLogin().equals(login)) {
                return account;}
        };
        return null;
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

    public Long next() {
        return sequence.incrementAndGet();
    }

    public AtomicLong getSequence() {
        return sequence;
    }
}
