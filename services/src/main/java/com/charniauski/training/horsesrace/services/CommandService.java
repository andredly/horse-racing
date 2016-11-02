package com.charniauski.training.horsesrace.services;

import com.charniauski.training.horsesrace.datamodel.Command;

/**
 * Created by Andre on 18.10.2016.
 */
public interface CommandService extends GenericService<Command,Long> {
    Command getByNameCommand(String nameCommand);

}
