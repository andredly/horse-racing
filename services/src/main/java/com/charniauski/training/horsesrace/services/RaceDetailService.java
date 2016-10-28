package com.charniauski.training.horsesrace.services;

import com.charniauski.training.horsesrace.daodb.customentity.RaceDetailWithHorse;
import com.charniauski.training.horsesrace.datamodel.RaceDetail;

/**
 * Created by Andre on 18.10.2016.
 */
public interface RaceDetailService extends GenericService<RaceDetail,Long> {

        public RaceDetailWithHorse getRaceDetailWithHorse(Long idRaceDetail);

}
