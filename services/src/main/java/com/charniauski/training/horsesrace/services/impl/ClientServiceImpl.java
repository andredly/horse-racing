package com.charniauski.training.horsesrace.services.impl;

import com.charniauski.training.horsesrace.daodb.ClientDao;
import com.charniauski.training.horsesrace.daodb.GenericDao;
import com.charniauski.training.horsesrace.datamodel.Account;
import com.charniauski.training.horsesrace.datamodel.Client;
import com.charniauski.training.horsesrace.services.AccountService;
import com.charniauski.training.horsesrace.services.ClientService;
import com.charniauski.training.horsesrace.services.exception.NoSuchEntityException;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    @Override
    public Long save(Client client)  {
        LOGGER.info("Save start create Client={}", client.getFirstName());
        Validate.notNull(client.getFirstName(),"Arguments FirstName may not by null");
        Validate.notNull(client.getLastName(),"Arguments LastName may not by null");
        Validate.notNull(client.getAddress(),"Arguments Address may not by null");
        Validate.notNull(client.getDate(),"Arguments Date may not by null");

        Account account = accountService.get(client.getId());
        if (account.getId() == null) throw new NoSuchEntityException("Account " + account.getLogin() + " not found");
        Client oldClient = clientDao.get(client.getId());
        if (oldClient == null) clientDao.insert(client);
        else clientDao.update(client);
        LOGGER.info("Save end create Account={}", account.getLogin());
        return client.getId();
    }
}
