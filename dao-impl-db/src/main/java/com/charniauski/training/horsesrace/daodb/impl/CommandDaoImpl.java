package com.charniauski.training.horsesrace.daodb.impl;

import com.charniauski.training.horsesrace.daodb.CommandDao;
import com.charniauski.training.horsesrace.datamodel.Command;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Andre on 19.10.2016.
 */
@Repository
public class CommandDaoImpl implements CommandDao {
    @Override
    public Command get(Long id) {
        // TODO: 19.10.2016  
        return null;
    }

    @Override
    public void insert(Command entity) {
// TODO: 19.10.2016 
    }

    @Override
    public void update(Command entity) {
// TODO: 19.10.2016 
    }

    @Override
    public void delete(Long id) {
// TODO: 19.10.2016 
    }

    @Override
    public List<Command> getAll() {
        // TODO: 19.10.2016 
        return null;
    }
}
