package com.charniauski.training.horsesrace.daodb;

import com.charniauski.training.horsesrace.datamodel.Command;

/**
 * Created by Andre on 19.10.2016.
 */
public interface CommandDao extends GenericDao<Command,Long>{

    Command getByNameCommand(String nameCommand);

}
