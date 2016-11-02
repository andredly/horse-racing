package com.charniauski.training.horsesrace.services.impl;

import com.charniauski.training.horsesrace.daodb.GenericDao;
import com.charniauski.training.horsesrace.daodb.RaceDetailDao;
import com.charniauski.training.horsesrace.datamodel.RaceDetail;
import com.charniauski.training.horsesrace.services.RaceDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

/**
 * Created by Andre on 19.10.2016.
 */
@Service
public class RaceDetailServiceImpl extends AbstractService<RaceDetail, Long> implements RaceDetailService {
    private static final Logger LOGGER = LoggerFactory.getLogger(RaceDetailServiceImpl.class);

    @Inject
    private RaceDetailDao raceDetailDao;

    @Override
    public GenericDao getGenericDao() {
        return raceDetailDao;
    }

    @Override
    public boolean saveHorseResult(Long raceCardId, Long horseId, Integer result) throws IllegalArgumentException{
        Long id = getIdByRacecourseAndHorse(raceCardId, horseId);
        if (id == null) {
            LOGGER.error("Incorrect argument saveHorseResult raceCardId={},horseId={},result={}",
                    raceCardId.toString(), horseId.toString(), result.toString());
            throw new IllegalArgumentException();}
        Long saveId = save(get(id));
        return saveId != null;
    }

    @Override
    public Long getIdByRacecourseAndHorse(Long raceCardId, Long horseId) {
        return raceDetailDao.getIdByRacecourseAndHorse(raceCardId, horseId);
    }
}
