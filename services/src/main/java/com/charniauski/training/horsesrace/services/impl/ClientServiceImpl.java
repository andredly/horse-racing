package com.charniauski.training.horsesrace.services.impl;

import com.charniauski.training.horsesrace.daodb.ClientDao;
import com.charniauski.training.horsesrace.daodb.GenericDao;
import com.charniauski.training.horsesrace.daodb.impl.AbstractDao;
import com.charniauski.training.horsesrace.datamodel.AbstractModel;
import com.charniauski.training.horsesrace.datamodel.Account;
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
public class ClientServiceImpl extends AbstractService<Client,Long> implements ClientService{


    @Inject
    private  ClientDao clientDao;


    @Override
    public GenericDao getGenericDao() {
        return clientDao;
    }
}
