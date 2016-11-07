package com.charniauski.training.horsesrace.daodb.impl;

import com.charniauski.training.horsesrace.daodb.RaceDetailDao;
import com.charniauski.training.horsesrace.datamodel.RaceDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.charniauski.training.horsesrace.daodb.util.SqlBuilder.sqlSelectEntity;
import static java.lang.String.format;

/**
 * Created by Andre on 19.10.2016.
 */
@Repository
public class RaceDetailDaoImpl extends AbstractDao<RaceDetail, Long> implements RaceDetailDao {

    @Override
    public RaceDetail getByRaceCardAndHorse(Long raceCardId, Long horseId) {
        String sql = format("%s WHERE race_card_id=%d AND horse_id=%d;", sqlSelectEntity(RaceDetail.class), raceCardId, horseId);
        return getEntity(sql, RaceDetail.class);
    }

    @Override
    public RaceDetail getByRaceCardAndCommand(Long raceCardId, Long commandId) {
        String sql = format("%s WHERE race_card_id=%d AND command_id=%d;", sqlSelectEntity(RaceDetail.class), raceCardId, commandId);
        return getEntity(sql, RaceDetail.class);
    }

    @Override
    public RaceDetail getByRaceCardAndNumberStartBox(Long raceCardId, Integer numberStartBox) {
        String sql = format("%s WHERE race_card_id=%d AND number_start_box=%d;", sqlSelectEntity(RaceDetail.class), raceCardId, numberStartBox);
        return getEntity(sql, RaceDetail.class);
    }

    @Override
    public List<RaceDetail> getByRaceCard(Long raceCardId) {
        String sql=String.format("SELECT * FROM race_card rc LEFT JOIN race_detail ON" +
                " rc.id = race_detail.race_card_id WHERE rc.id=%d;",raceCardId);
        return getListEntity(sql,RaceDetail.class);
    }


}
