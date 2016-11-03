package com.charniauski.training.horsesrace.services.impl;

import com.charniauski.training.horsesrace.daodb.CommandDao;
import com.charniauski.training.horsesrace.daodb.GenericDao;
import com.charniauski.training.horsesrace.datamodel.Account;
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
    public Long save(Command command) throws NullPointerException, IllegalArgumentException {
        if (command.getJockey() == null || command.getTrainer() == null || command.getUrlImageColor() == null)
            throw new NullPointerException(String.format("Arguments may not by null: Trainer=%s, Jockey=%s," +
                    "UrlImageColor=%s", command.getTrainer(),command.getJockey(),  command.getUrlImageColor()));
        Long commandId = null;
        if (command.getId() == null) {
            Command oldCommand = commandDao.getByTrainerAndJockeyAndUrl(command.getTrainer(),command.getJockey(),command.getUrlImageColor());
            if (oldCommand!=null)throw new IllegalArgumentException("Command already exists");
            commandId = commandDao.insert(command);
        } else {
            commandDao.update(command);
            commandId=command.getId();
        }
        return commandId;
    }

    @Override
    public Command getByTrainerAndJockeyAndUrl(String trainer, String jockey, String urlImage) {
        return commandDao.getByTrainerAndJockeyAndUrl(trainer,jockey,urlImage);
    }
}
