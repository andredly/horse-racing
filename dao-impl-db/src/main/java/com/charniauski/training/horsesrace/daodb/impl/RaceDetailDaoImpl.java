package com.charniauski.training.horsesrace.daodb.impl;

import com.charniauski.training.horsesrace.daodb.RaceDetailDao;
import com.charniauski.training.horsesrace.datamodel.RaceDetail;
import org.springframework.stereotype.Repository;

import static com.charniauski.training.horsesrace.daodb.util.SqlBuilder.sqlSelectEntity;
import static java.lang.String.format;

/**
 * Created by Andre on 19.10.2016.
 */
@Repository
public class RaceDetailDaoImpl extends AbstractDao<RaceDetail, Long> implements RaceDetailDao {

    @Override
    public Long getIdByRaceCardAndHorse(Long raceCardId, Long horseId) {
        String sql = format("%s WHERE race_card_id=%d AND horse_id=%d;", sqlSelectEntity(RaceDetail.class), raceCardId, horseId);
        return getEntity(sql, RaceDetail.class).getId();
    }

}
