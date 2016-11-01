package com.charniauski.training.horsesrace.services.impl;

import com.charniauski.training.horsesrace.daodb.CommandDao;
import com.charniauski.training.horsesrace.daodb.GenericDao;
import com.charniauski.training.horsesrace.datamodel.Command;
import com.charniauski.training.horsesrace.services.CommandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by Andre on 19.10.2016.
 */
@Service

public class CommandServiceImpl extends AbstractService<Command,Long> implements CommandService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommandServiceImpl.class);
    @Inject
    private CommandDao commandDao;


    @Override
    public GenericDao getGenericDao() {
        return commandDao;
    }

    @Override
    public Command getCommandByNameCommand(String nameCommand) {
        return commandDao.getCommandByNameCommand(nameCommand);
    }
}
