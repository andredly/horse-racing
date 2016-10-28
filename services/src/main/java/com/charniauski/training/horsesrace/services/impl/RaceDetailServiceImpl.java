package com.charniauski.training.horsesrace.services.impl;

import com.charniauski.training.horsesrace.daodb.GenericDao;
import com.charniauski.training.horsesrace.daodb.RaceDetailDao;
import com.charniauski.training.horsesrace.daodb.customentity.RaceDetailWithHorse;
import com.charniauski.training.horsesrace.datamodel.RaceDetail;
import com.charniauski.training.horsesrace.services.RaceDetailService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by Andre on 19.10.2016.
 */
@Service
public class RaceDetailServiceImpl extends AbstractService<RaceDetail,Long> implements RaceDetailService {


    @Inject
    private RaceDetailDao raceDetailDao;


    @Override
    public GenericDao getGenericDao() {
        return raceDetailDao;
    }

    @Override
    public RaceDetailWithHorse getRaceDetailWithHorse(Long idRaceDetail) {
        return raceDetailDao.getWithHorse(idRaceDetail);
    }
}
