package com.charniauski.training.horsesrace.services;

import com.charniauski.training.horsesrace.datamodel.AbstractModel;
import com.charniauski.training.horsesrace.datamodel.Client;

import java.util.List;

/**
 * Created by Andre on 18.10.2016.
 */
public interface ClientService {

    void saveAll(List<Client> clients);

    void save(Client client);

    boolean delete(Client client);

    Client get(Long id);
}
