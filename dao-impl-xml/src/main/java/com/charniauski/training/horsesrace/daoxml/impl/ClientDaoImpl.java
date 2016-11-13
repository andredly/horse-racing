package com.charniauski.training.horsesrace.daoxml.impl;

import com.charniauski.training.horsesrace.daoapi.ClientDao;
import com.charniauski.training.horsesrace.datamodel.Client;
import org.springframework.stereotype.Repository;

import java.util.concurrent.atomic.AtomicLong;

import static com.charniauski.training.horsesrace.daoxml.util.SqlBuilder.sqlSelectEntity;
import static java.lang.String.format;

/**
 * Created by Andre on 19.10.2016.
 */
@Repository
public class ClientDaoImpl extends AbstractDao<Client,Long> implements ClientDao {

    private final AtomicLong sequence=new AtomicLong(0L);
    @Override
    public Client getByLogin(String login) {
        String sql = format("%s WHERE login='%s';", sqlSelectEntity(Client.class), login);
        return getEntity(sql,Client.class);
    }

    public Long next() {
        return sequence.incrementAndGet();
    }

    public AtomicLong getSequence() {
        return sequence;
    }
}
