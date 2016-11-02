package com.charniauski.training.horsesrace.services.impl;

import com.charniauski.training.horsesrace.daodb.ClientDao;
import com.charniauski.training.horsesrace.daodb.GenericDao;
import com.charniauski.training.horsesrace.datamodel.Client;
import com.charniauski.training.horsesrace.services.AccountService;
import com.charniauski.training.horsesrace.services.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by Andre on 19.10.2016.
 */
@Service
public class ClientServiceImpl extends AbstractService<Client, Long> implements ClientService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientServiceImpl.class);
    @Inject
    private ClientDao clientDao;

    @Inject
    private AccountService accountService;

    @Override
    public GenericDao getGenericDao() {
        return clientDao;
    }


    @Override
    public void update(Client client){
//        if (accountService.get(client.getId())==null)throw new NoSuchEntityException("Account nod found");
        clientDao.update(client);
    }

    @Override
    public Long save(Client client){
//        if (accountService.get(client.getId())==null)throw new NoSuchEntityException("Account nod found");
        return clientDao.insert(client);
    }
}
