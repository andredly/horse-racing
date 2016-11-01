package com.charniauski.training.horsesrace.daodb.impl;

import com.charniauski.training.horsesrace.daodb.CommandDao;
import com.charniauski.training.horsesrace.datamodel.Command;
import com.charniauski.training.horsesrace.datamodel.Horse;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import java.util.Map;

import static com.charniauski.training.horsesrace.daodb.util.ReflectionUtil.getBean;
import static com.charniauski.training.horsesrace.daodb.util.SqlBuilder.sqlSelectEntity;
import static java.lang.String.format;

/**
 * Created by Andre on 19.10.2016.
 */
@Repository
public class CommandDaoImpl extends AbstractDao<Command,Long> implements CommandDao{

    @Override
    public Command getCommandByNameCommand(String nameCommand) {
        String sql = format("%s WHERE name_command='%s';", sqlSelectEntity(Command.class), nameCommand);
        Map<String, Object> stringObjectMap;
        Command bean;
        try {
            stringObjectMap = getJdbcTemplate().queryForMap(sql);
            bean = getBean(stringObjectMap, Command.class);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
        return bean;
    }
}
