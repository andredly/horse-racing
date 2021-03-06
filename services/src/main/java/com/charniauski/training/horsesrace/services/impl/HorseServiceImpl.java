package com.charniauski.training.horsesrace.services.impl;


import com.charniauski.training.horsesrace.daoapi.GenericDao;
import com.charniauski.training.horsesrace.daoapi.HorseDao;
import com.charniauski.training.horsesrace.datamodel.Horse;
import com.charniauski.training.horsesrace.services.HorseService;
import com.charniauski.training.horsesrace.services.cacherequest.Cached;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

/**
 * Created by Andre on 19.10.2016.
 */
@Service
public class HorseServiceImpl extends AbstractService<Horse, Long> implements HorseService {

    private static final Logger LOGGER = LoggerFactory.getLogger(HorseServiceImpl.class);
    @Inject
    private HorseDao horseDao;


    @Override
    public GenericDao<Horse, Long> getGenericDao() {
        return horseDao;
    }

    @Cached(timeToLiveSeconds = 100)
    @Override
    public Horse getByNickName(String nickName) {
        return horseDao.getByNickName(nickName);
    }

    @Cached(timeToLiveSeconds = 100)
    @Override
    public Horse getByRaceDetail(Long raceDetail) {
        return horseDao.getByRaceDetail(raceDetail);
    }

    @Transactional
    @Override
    public Long save(Horse horse) {
//        validateDataHorse(horse);
        Long horseId;
        if (horse.getId() == null) {
            Horse oldHorse = horseDao.getByNickName(horse.getNickName());
            if (oldHorse != null)
                throw new IllegalArgumentException("NickName " + horse.getNickName() + " already exists");
            horseId = horseDao.insert(horse);
        } else {
            horseDao.update(horse);
            horseId = horse.getId();
        }
        return horseId;
    }

//    private void validateDataHorse(Horse horse) {
//        Validate.notNull(horse.getNickName(),"Arguments NickName may not by null");
//        Validate.notNull(horse.getEquipmentWeight(),"Arguments EquipmentWeight may not by null");
//        Validate.notNull(horse.getOwner(),"Arguments Owner may not by null");
//        Validate.notNull(horse.getAge(),"Arguments Age may not by null");
//    }
}
