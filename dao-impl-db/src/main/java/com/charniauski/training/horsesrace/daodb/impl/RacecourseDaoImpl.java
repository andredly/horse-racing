package com.charniauski.training.horsesrace.daodb.impl;

import com.charniauski.training.horsesrace.daodb.RacecourseDao;
import com.charniauski.training.horsesrace.datamodel.Racecourse;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import static com.charniauski.training.horsesrace.daodb.util.ReflectionUtil.getBean;
import static com.charniauski.training.horsesrace.daodb.util.SqlBuilder.sqlSelectEntity;

/**
 * Created by Andre on 19.10.2016.
 */
@Repository
public class RacecourseDaoImpl extends AbstractDao<Racecourse,Long> implements RacecourseDao{


    @Override
    public List<Racecourse> getAllAfterCurrentDate() {
        List<Racecourse> listT = new ArrayList<>();
        String sql = "SELECT rs.id, rs.name,rs.country FROM racecourse rs LEFT JOIN race_card rc" +
                " ON rs.id = rc.racecourse_id WHERE rc.date_start>(current_timestamp+INTERVAL '5 second')" +
                " GROUP BY rs.id ORDER BY rs.name;";
        List<Map<String, Object>> listMap = getJdbcTemplate().queryForList(sql);
        for (Map<String, Object> map : listMap) {
            Racecourse entity = getBean(map, Racecourse.class);
            listT.add(entity);
        }
        return listT;
    }
}
