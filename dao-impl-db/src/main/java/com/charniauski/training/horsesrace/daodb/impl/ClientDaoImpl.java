package com.charniauski.training.horsesrace.daodb.impl;

import com.charniauski.training.horsesrace.daodb.ClientDao;
import com.charniauski.training.horsesrace.datamodel.Client;
import org.springframework.stereotype.Repository;

/**
 * Created by Andre on 19.10.2016.
 */
@Repository
public class ClientDaoImpl extends AbstractDao<Client,Long> implements ClientDao{

}
