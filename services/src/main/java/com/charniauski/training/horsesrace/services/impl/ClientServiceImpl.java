package com.charniauski.training.horsesrace.services.impl;

import com.charniauski.training.horsesrace.daodb.ClientDao;
import com.charniauski.training.horsesrace.daodb.GenericDao;
import com.charniauski.training.horsesrace.daodb.impl.AbstractDao;
import com.charniauski.training.horsesrace.datamodel.AbstractModel;
import com.charniauski.training.horsesrace.datamodel.Account;
import com.charniauski.training.horsesrace.datamodel.Client;
import com.charniauski.training.horsesrace.services.AccountService;
import com.charniauski.training.horsesrace.services.ClientService;
import com.charniauski.training.horsesrace.services.exception.NoSuchEntityException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.inject.Inject;
import java.util.List;

import static org.springframework.util.Assert.*;

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
