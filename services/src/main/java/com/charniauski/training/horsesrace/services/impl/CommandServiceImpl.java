package com.charniauski.training.horsesrace.services.impl;

import com.charniauski.training.horsesrace.daoapi.CommandDao;
import com.charniauski.training.horsesrace.daoapi.GenericDao;
import com.charniauski.training.horsesrace.datamodel.Command;
import com.charniauski.training.horsesrace.services.CommandService;
import com.charniauski.training.horsesrace.services.cacherequest.Cached;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

/**
 * Created by Andre on 19.10.2016.
 */
@Service

public class CommandServiceImpl extends AbstractService<Command,Long> implements CommandService {

    @Inject
    private CommandDao commandDao;


    @Override
    public GenericDao<Command, Long> getGenericDao() {
        return commandDao;
    }


    @Transactional
    @Override
    public Long save(Command command) {
//        validateDataCommand(command);
        Long commandId;
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

//    private void validateDataCommand(Command command) {
//        Validate.notNull(command.getJockey(),"Arguments Jockey may not by null");
//        Validate.notNull(command.getTrainer(),"Arguments Trainer may not by null");
//        Validate.notNull(command.getUrlImageColor(),"Arguments UrlImageColor may not by null");
//    }

    @Cached(timeToLiveSeconds = 500)
    @Override
    public Command getByTrainerAndJockeyAndUrl(String trainer, String jockey, String urlImage) {
        return commandDao.getByTrainerAndJockeyAndUrl(trainer,jockey,urlImage);
    }
}
