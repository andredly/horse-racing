package com.charniauski.training.horsesrace.daodb.impl;

import com.charniauski.training.horsesrace.daodb.RaceCardDao;
import com.charniauski.training.horsesrace.datamodel.RaceCard;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Andre on 19.10.2016.
 */
@Repository
public class RaceCardDaoImpl extends AbstractDao<RaceCard,Long> implements RaceCardDao{

    @Override
    public List<RaceCard> getAllByRacecourseAfterCurrentDate(Long racecourseId) {
        String sql=String.format("SELECT rc.id, rc.date_start, rc.date_finish, rc.race_type" +
                " FROM race_card rc LEFT JOIN race_detail rd ON rc.id = rd.race_card_id" +
                " WHERE rc.date_start>(current_timestamp+INTERVAL '5 second')"  +
                " AND racecourse_id=%d GROUP BY rc.id ORDER BY rc.date_start;",racecourseId);
        return getListEntity(sql,RaceCard.class);
    }

    @Override
    public List<RaceCard> getAllAfterCurrentDate() {
        String sql = "SELECT rc.id, rc.date_start, rc.date_finish, rc.race_type" +
                " FROM race_card rc LEFT JOIN race_detail rd ON rc.id = rd.race_card_id" +
                " WHERE rc.date_start>(current_timestamp+INTERVAL '5 second')" +
                " GROUP BY rc.id ORDER BY rc.date_start;";
        return getListEntity(sql,RaceCard.class);
    }



}
