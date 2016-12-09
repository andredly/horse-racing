package com.charniauski.training.horsesrace.daoxml.impl;

import com.charniauski.training.horsesrace.daoapi.CommandDao;
import com.charniauski.training.horsesrace.datamodel.Command;
import org.springframework.stereotype.Repository;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Andre on 19.10.2016.
 */
@Repository
public class CommandDaoImpl extends AbstractDao<Command, Long> implements CommandDao {

    private final AtomicLong sequence = new AtomicLong(1L);

    @Override
    public Command getByTrainerAndJockeyAndUrl(String trainer, String jockey, String urlImage) {
        return readCollection().stream().filter(cm -> cm.getTrainer().equals(trainer)
                && cm.getJockey().equals(jockey) && cm.getUrlImageColor().equals(urlImage)).findFirst().orElse(null);
    }

    public Long next() {
        return sequence.getAndIncrement();
    }

    public AtomicLong getSequence() {
        return sequence;
    }
}
