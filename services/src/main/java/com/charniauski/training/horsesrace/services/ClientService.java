package com.charniauski.training.horsesrace.services;

import com.charniauski.training.horsesrace.datamodel.Client;

/**
 * Created by Andre on 18.10.2016.
 */
public interface ClientService extends GenericService<Client,Long> {

    void update(Client client);

}
