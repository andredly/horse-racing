package com.charniauski.training.horsesrace.daodb;

import com.charniauski.training.horsesrace.datamodel.RaceDetail;

/**
 * Created by Andre on 19.10.2016.
 */
public interface RaceDetailDao extends GenericDao<RaceDetail, Long> {

    Long getIdByRaceCardAndHorse(Long raceCardId, Long horseId);

}
