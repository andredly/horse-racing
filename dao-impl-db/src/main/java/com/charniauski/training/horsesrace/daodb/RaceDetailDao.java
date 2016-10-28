package com.charniauski.training.horsesrace.daodb;

import com.charniauski.training.horsesrace.daodb.customentity.RaceDetailWithHorse;
import com.charniauski.training.horsesrace.datamodel.RaceDetail;

import java.util.List;

/**
 * Created by Andre on 19.10.2016.
 */
public interface RaceDetailDao extends GenericDao<RaceDetail, Long> {

    RaceDetailWithHorse getWithHorse(Long raceDetailId);
}
