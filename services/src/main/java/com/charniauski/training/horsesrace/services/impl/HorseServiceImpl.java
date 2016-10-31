package com.charniauski.training.horsesrace.services.impl;

import com.charniauski.training.horsesrace.daodb.EventDao;
import com.charniauski.training.horsesrace.daodb.GenericDao;
import com.charniauski.training.horsesrace.daodb.HorseDao;
import com.charniauski.training.horsesrace.datamodel.Command;
import com.charniauski.training.horsesrace.datamodel.Event;
import com.charniauski.training.horsesrace.datamodel.Horse;
import com.charniauski.training.horsesrace.services.CommandService;
import com.charniauski.training.horsesrace.services.EventService;
import com.charniauski.training.horsesrace.services.HorseService;
import com.charniauski.training.horsesrace.services.wrapper.HorseWithCommand;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by Andre on 19.10.2016.
 */
@Service
public class HorseServiceImpl extends AbstractService<Horse,Long> implements HorseService {


    @Inject
    private HorseDao horseDao;

    @Inject
    private CommandService commandService;


    @Override
    public GenericDao getGenericDao() {
        return horseDao;
    }

    @Override
    public HorseWithCommand getHorseWithCommand(Long horseId) {
        Horse horse = get(horseId);
        if (horse==null)return null;
        Command command = commandService.get(horse.getCommandId());
        HorseWithCommand horseWithCommand=new HorseWithCommand();
        horseWithCommand.setHorse(horse);
        horseWithCommand.setCommand(command);
        return horseWithCommand;
    }
}
