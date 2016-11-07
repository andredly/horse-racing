package com.charniauski.training.horsesrace.daodb.impl;

import com.charniauski.training.horsesrace.daodb.ClientDao;
import com.charniauski.training.horsesrace.datamodel.Client;
import org.springframework.stereotype.Repository;

import static com.charniauski.training.horsesrace.daodb.util.SqlBuilder.sqlSelectEntity;
import static java.lang.String.format;

/**
 * Created by Andre on 19.10.2016.
 */
@Repository
public class ClientDaoImpl extends AbstractDao<Client,Long> implements ClientDao{

    @Override
    public Client getByLogin(String login) {
        String sql = format("%s WHERE login='%s';", sqlSelectEntity(Client.class), login);
        return getEntity(sql,Client.class);
    }
}
