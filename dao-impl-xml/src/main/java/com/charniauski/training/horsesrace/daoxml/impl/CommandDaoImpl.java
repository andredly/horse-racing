package com.charniauski.training.horsesrace.daoxml.impl;

import com.charniauski.training.horsesrace.daoapi.CommandDao;
import com.charniauski.training.horsesrace.datamodel.Command;
import org.springframework.stereotype.Repository;

import java.util.concurrent.atomic.AtomicLong;

import static com.charniauski.training.horsesrace.daoxml.util.SqlBuilder.sqlSelectEntity;
import static java.lang.String.format;

/**
 * Created by Andre on 19.10.2016.
 */
@Repository
public class CommandDaoImpl extends AbstractDao<Command,Long> implements CommandDao {

    private final AtomicLong sequence=new AtomicLong(0L);
    @Override
    public Command getByTrainerAndJockeyAndUrl(String trainer, String jockey, String urlImage) {
        String sql = format("%s WHERE trainer='%s' AND jockey='%s' AND url_image_color='%s';",
                sqlSelectEntity(Command.class), trainer, jockey,urlImage);
        return getEntity(sql, Command.class);
    }

    public Long next() {
        return sequence.incrementAndGet();
    }

    public AtomicLong getSequence() {
        return sequence;
    }
}
