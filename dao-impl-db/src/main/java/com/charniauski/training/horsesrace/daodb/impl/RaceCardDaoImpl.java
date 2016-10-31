package com.charniauski.training.horsesrace.daodb.impl;

import com.charniauski.training.horsesrace.daodb.RaceCardDao;
import com.charniauski.training.horsesrace.datamodel.RaceCard;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.charniauski.training.horsesrace.daodb.util.ReflectionUtil.getBean;

/**
 * Created by Andre on 19.10.2016.
 */
@Repository
public class RaceCardDaoImpl extends AbstractDao<RaceCard,Long> implements RaceCardDao{

    @Override
    public List<RaceCard> getAllRaceCardAfterCurrentDate(Long racecourseId) {
        List<RaceCard> listT = new ArrayList<>();
        String sql = "SELECT rc.id, rc.date_start, rc.date_finish, rc.race_type" +
                " FROM race_card rc LEFT JOIN race_detail rd ON rc.id = rd.race_card_id" +
                " WHERE rc.date_start>(current_timestamp+INTERVAL '5 second')" +
                " GROUP BY rc.id ORDER BY rc.date_start;";
        List<Map<String, Object>> listMap = getJdbcTemplate().queryForList(sql);
        for (Map<String, Object> map : listMap) {
            RaceCard entity = getBean(map, RaceCard.class);
            listT.add(entity);
        }
        return listT;
    }

    @Override
    public Date getDateStartRaceCard(Long raceCardId) {
        //// TODO: 29.10.2016
        return null;
    }
}
