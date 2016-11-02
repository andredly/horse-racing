package com.charniauski.training.horsesrace.services;

import com.charniauski.training.horsesrace.datamodel.RaceDetail;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Andre on 18.10.2016.
 */
public interface RaceDetailService extends GenericService<RaceDetail,Long> {

    @Transactional
    boolean saveHorseResult(Long raceCardId, Long horseId, Integer result);

    Long getIdByRacecourseAndHorse(Long raceCardId, Long horseId);

    Integer getHorseResultByRaceCardId(Long raceCardId);
}
