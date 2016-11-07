package com.charniauski.training.horsesrace.daodb;

import com.charniauski.training.horsesrace.datamodel.Client;

/**
 * Created by Andre on 19.10.2016.
 */
public interface ClientDao extends GenericDao<Client, Long>{
    Client getByLogin(String login);
}
