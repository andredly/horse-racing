package com.charniauski.training.horsesrace.services.impl;

import com.charniauski.training.horsesrace.daodb.ClientDao;
import com.charniauski.training.horsesrace.daodb.GenericDao;
import com.charniauski.training.horsesrace.daodb.impl.AbstractDao;
import com.charniauski.training.horsesrace.datamodel.AbstractModel;
import com.charniauski.training.horsesrace.datamodel.Client;
import com.charniauski.training.horsesrace.services.ClientService;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.inject.Inject;
import java.util.List;

import static org.springframework.util.Assert.*;

/**
 * Created by Andre on 19.10.2016.
 */
@Service
public class ClientServiceImpl implements ClientService {

    @Inject
    private ClientDao clientDao;

    @Override
    public void saveAll(List<Client> clients) {

    }

    @Override
    public void save(Client client) {
        if(client==null)throw new IllegalArgumentException();

        if (client.getId() == null) {
            clientDao.insert(client);
        } else {
            clientDao.update(client);
        }
    }


    @Override
    public boolean delete(Client client) {
        if (client==null)return false;
        return clientDao.delete(client.getId());
    }

    @Override
    public Client get(Long id) {
        return clientDao.get(id);
    }
}
