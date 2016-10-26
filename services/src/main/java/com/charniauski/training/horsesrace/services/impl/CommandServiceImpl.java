package com.charniauski.training.horsesrace.services.impl;

import com.charniauski.training.horsesrace.daodb.CommandDao;
import com.charniauski.training.horsesrace.daodb.GenericDao;
import com.charniauski.training.horsesrace.datamodel.Command;
import com.charniauski.training.horsesrace.services.CommandService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by Andre on 19.10.2016.
 */
@Service
public class CommandServiceImpl extends AbstractService<Command,Long> implements CommandService {


    @Inject
    private CommandDao commandDao;


    @Override
    public GenericDao getGenericDao() {
        return commandDao;
    }
}
