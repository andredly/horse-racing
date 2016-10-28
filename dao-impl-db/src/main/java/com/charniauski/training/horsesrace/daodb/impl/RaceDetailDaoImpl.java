package com.charniauski.training.horsesrace.daodb.impl;

import com.charniauski.training.horsesrace.daodb.RaceDetailDao;
import com.charniauski.training.horsesrace.daodb.customentity.RaceDetailWithHorse;
import com.charniauski.training.horsesrace.daodb.util.ReflectionUtil;
import com.charniauski.training.horsesrace.datamodel.Horse;
import com.charniauski.training.horsesrace.datamodel.RaceDetail;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by Andre on 19.10.2016.
 */
@Repository
public class RaceDetailDaoImpl extends AbstractDao<RaceDetail, Long> implements RaceDetailDao {
    public RaceDetailDaoImpl() {
        super(RaceDetail.class);
    }

    @Override
    public RaceDetailWithHorse getWithHorse(Long raceDetailId) {
        Map<String, Object> stringObjectMap = getJdbcTemplate().queryForMap("SELECT * FROM race_detail rd " +
                "LEFT JOIN horse hr ON rd.horse_id = hr.id WHERE rd.id=" + raceDetailId + ";");
        System.out.println(stringObjectMap);
        RaceDetail raceDetail = ReflectionUtil.getBean(stringObjectMap, RaceDetail.class);
        raceDetail.setId(raceDetailId);
        Horse horse = ReflectionUtil.getBean(stringObjectMap, Horse.class);
        RaceDetailWithHorse raceDetailWithHorse = new RaceDetailWithHorse();
        raceDetailWithHorse.setHorse(horse);
        raceDetailWithHorse.setRaceDetail(raceDetail);
        return raceDetailWithHorse;
    }
}
