package com.charniauski.training.horsesrace.daodb;

import com.charniauski.training.horsesrace.datamodel.Command;

import java.util.List;

/**
 * Created by Andre on 19.10.2016.
 */
public interface CommandDao {

    Command get(Long id);

    void insert(Command entity);

    void update(Command entity);

    void delete(Long id);

    List<Command> getAll();
}
