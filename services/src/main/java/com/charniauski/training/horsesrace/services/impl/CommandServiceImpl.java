package com.charniauski.training.horsesrace.services.impl;

import com.charniauski.training.horsesrace.daoapi.CommandDao;
import com.charniauski.training.horsesrace.daoapi.GenericDao;
import com.charniauski.training.horsesrace.datamodel.Command;
import com.charniauski.training.horsesrace.services.CommandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public GenericDao<Command, Long> getGenericDao() {
        return commandDao;
    }


    @Transactional
    @Override
    public Long save(Command command) throws NullPointerException, IllegalArgumentException {
//        Validate.notNull(command.getJockey(),"Arguments Jockey may not by null");
//        Validate.notNull(command.getTrainer(),"Arguments Trainer may not by null");
//        Validate.notNull(command.getUrlImageColor(),"Arguments UrlImageColor may not by null");
        Long commandId;
        if (command.getId() == null) {
//            Command oldCommand = commandDao.getByTrainerAndJockeyAndUrl(command.getTrainer(),command.getJockey(),command.getUrlImageColor());
//            if (oldCommand!=null)throw new IllegalArgumentException("Command already exists");
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
