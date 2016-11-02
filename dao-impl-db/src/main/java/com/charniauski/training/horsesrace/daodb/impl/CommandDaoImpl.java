package com.charniauski.training.horsesrace.daodb.impl;

import com.charniauski.training.horsesrace.daodb.CommandDao;
import com.charniauski.training.horsesrace.datamodel.Command;
import org.springframework.stereotype.Repository;

import static com.charniauski.training.horsesrace.daodb.util.SqlBuilder.sqlSelectEntity;
import static java.lang.String.format;

/**
 * Created by Andre on 19.10.2016.
 */
@Repository
public class CommandDaoImpl extends AbstractDao<Command,Long> implements CommandDao{

    @Override
    public Command getByNameCommand(String nameCommand) {
        String sql = format("%s WHERE name_command='%s';", sqlSelectEntity(Command.class), nameCommand);
        return getEntity(sql,Command.class);
    }
}
