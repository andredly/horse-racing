package com.charniauski.training.horsesrace.services;

import com.charniauski.training.horsesrace.daodb.customentity.RaceDetailWithHorse;
import com.charniauski.training.horsesrace.datamodel.RaceCard;
import com.charniauski.training.horsesrace.datamodel.RaceDetail;
import com.charniauski.training.horsesrace.datamodel.Racecourse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by Andre on 18.10.2016.
 */
public interface RaceDetailService extends GenericService<RaceDetail,Long> {

        RaceDetailWithHorse getRaceDetailWithHorse(Long idRaceDetail);



}
