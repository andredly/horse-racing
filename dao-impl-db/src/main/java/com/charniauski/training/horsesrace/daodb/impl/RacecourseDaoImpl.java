package com.charniauski.training.horsesrace.daodb.impl;

import com.charniauski.training.horsesrace.daodb.RacecourseDao;
import com.charniauski.training.horsesrace.daodb.util.ReflectionUtil;
import com.charniauski.training.horsesrace.daodb.util.SqlBuilder;
import com.charniauski.training.horsesrace.datamodel.Racecourse;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.charniauski.training.horsesrace.daodb.util.ReflectionUtil.*;
import static com.charniauski.training.horsesrace.daodb.util.ReflectionUtil.getBean;
import static com.charniauski.training.horsesrace.daodb.util.SqlBuilder.*;
import static java.lang.String.*;

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

    @Override
    public Racecourse getRacecourseByName(String name) {
        String sql= format("%s WHERE name='%s';",sqlSelectEntity(Racecourse.class),name);
        Map<String, Object> stringObjectMap;
        try {
             stringObjectMap= getJdbcTemplate().queryForMap(sql);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
        return getBean(stringObjectMap,Racecourse.class);
    }
}
