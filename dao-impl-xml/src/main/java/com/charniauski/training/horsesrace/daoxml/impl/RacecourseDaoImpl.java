package com.charniauski.training.horsesrace.daoxml.impl;

import com.charniauski.training.horsesrace.daoapi.RacecourseDao;
import com.charniauski.training.horsesrace.datamodel.Racecourse;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static com.charniauski.training.horsesrace.daoxml.util.SqlBuilder.sqlSelectEntity;
import static java.lang.String.format;

/**
 * Created by Andre on 19.10.2016.
 */
@Repository
public class RacecourseDaoImpl extends AbstractDao<Racecourse,Long> implements RacecourseDao {

    private final AtomicLong sequence=new AtomicLong(0L);

    @Override
    public List<Racecourse> getAllAfterCurrentDate() {
        String sql = "SELECT rs.id, rs.name,rs.country FROM racecourse rs LEFT JOIN race_card rc" +
                " ON rs.id = rc.racecourse_id WHERE rc.date_start>(current_timestamp+INTERVAL '5 second')" +
                " AND  rc.date_start<(current_timestamp+INTERVAL '24 hours')" +
                " GROUP BY rs.id ORDER BY rs.name;";
        return getListEntity(sql,Racecourse.class);
    }

    @Override
    public Racecourse getByName(String name) {
        String sql= format("%s WHERE name='%s';",sqlSelectEntity(Racecourse.class),name);
        return getEntity(sql, Racecourse.class);
    }
    public Long next() {
        return sequence.incrementAndGet();
    }

    public AtomicLong getSequence() {
        return sequence;
    }
}
