package com.charniauski.training.horsesrace.daodb.impl;

import com.charniauski.training.horsesrace.daodb.RaceDetailDao;
import com.charniauski.training.horsesrace.datamodel.Account;
import com.charniauski.training.horsesrace.datamodel.RaceDetail;
import com.charniauski.training.horsesrace.datamodel.Racecourse;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import java.util.Map;

import static com.charniauski.training.horsesrace.daodb.util.ReflectionUtil.getBean;
import static com.charniauski.training.horsesrace.daodb.util.SqlBuilder.sqlSelectEntity;
import static java.lang.String.format;

/**
 * Created by Andre on 19.10.2016.
 */
@Repository
public class RaceDetailDaoImpl extends AbstractDao<RaceDetail, Long> implements RaceDetailDao {

    @Override
    public Long getIdByRacecourseAndHorse(Long raceCardId, Long horseId) {
        String sql = format("%s WHERE race_card_id=%d AND horse_id=%d;", sqlSelectEntity(RaceDetail.class), raceCardId, horseId);
        Map<String, Object> stringObjectMap;
        RaceDetail bean;
        try {
            stringObjectMap = getJdbcTemplate().queryForMap(sql);
            bean = getBean(stringObjectMap, RaceDetail.class);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
        return bean.getId();
    }

    @Override
    public Integer getHorseResultByRaceCardId(Long raceCardId) {


        /////// TODO: 02.11.2016  Отдельный метод для  Map<String, Object> stringObjectMap;
        return null;
    }
}
