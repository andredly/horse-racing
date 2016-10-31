package com.charniauski.training.horsesrace.services;

import com.charniauski.training.horsesrace.datamodel.Horse;
import com.charniauski.training.horsesrace.services.wrapper.HorseWithCommand;

import javax.inject.Inject;

/**
 * Created by Andre on 18.10.2016.
 */
public interface HorseService extends GenericService<Horse,Long> {

    HorseWithCommand getHorseWithCommand(Long horseId);

}
