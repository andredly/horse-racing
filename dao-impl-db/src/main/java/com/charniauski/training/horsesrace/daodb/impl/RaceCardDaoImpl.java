package com.charniauski.training.horsesrace.daodb.impl;

import com.charniauski.training.horsesrace.daoapi.RaceCardDao;
import com.charniauski.training.horsesrace.datamodel.RaceCard;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static java.lang.String.format;

/**
 * Created by Andre on 19.10.2016.
 */
@Repository
public class RaceCardDaoImpl extends AbstractDao<RaceCard,Long> implements RaceCardDao {

    @Override
    public List<RaceCard> getAllByRacecourseAfterCurrentDate(Long racecourseId) {
        String sql=String.format("SELECT rc.id, rc.racecourse_id, rc.date_start, rc.date_finish, rc.race_type" +
                " FROM race_card rc LEFT JOIN race_detail rd ON rc.id = rd.race_card_id" +
                " WHERE rc.date_start>(current_timestamp+INTERVAL '5 second') AND" +
                "  rc.date_start<(current_timestamp+INTERVAL '24 hours')"  +
                " AND racecourse_id=%d GROUP BY rc.id ORDER BY rc.date_start;",racecourseId);
        return getListEntity(sql,RaceCard.class);
    }


    @Override
    public RaceCard getByEvent(Long eventId) {
        String sql= format("SELECT rc.id, rc.racecourse_id, rc.date_start, rc.date_finish," +
                " rc.race_type FROM race_card rc LEFT JOIN race_detail rd ON" +
                " rc.id = rd.race_card_id LEFT JOIN event ev ON rd.id = ev.race_detail_id" +
                " WHERE ev.id=%d",eventId);
        return getEntity(sql, RaceCard.class);
    }

    @Override
    public List<RaceCard> getAllForIntervalTime(Date firstDate, Date lastDate) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm a z");
        String sql= format("SELECT rc.id, rc.racecourse_id, rc.date_start, rc.date_finish, rc.race_type" +
                " FROM race_card rc WHERE rc.date_start BETWEEN '%s' AND '%s';",
                simpleDateFormat.format(firstDate),simpleDateFormat.format(lastDate));
        return getListEntity(sql,RaceCard.class);
    }

}
