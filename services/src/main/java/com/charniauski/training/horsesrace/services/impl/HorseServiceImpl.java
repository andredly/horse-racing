package com.charniauski.training.horsesrace.services.impl;

import com.charniauski.training.horsesrace.daodb.GenericDao;
import com.charniauski.training.horsesrace.daodb.HorseDao;
import com.charniauski.training.horsesrace.datamodel.Account;
import com.charniauski.training.horsesrace.datamodel.Horse;
import com.charniauski.training.horsesrace.services.HorseService;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

/**
 * Created by Andre on 19.10.2016.
 */
@Service
public class HorseServiceImpl extends AbstractService<Horse,Long> implements HorseService {

    private static final Logger LOGGER = LoggerFactory.getLogger(HorseServiceImpl.class);
    @Inject
    private HorseDao horseDao;


    @Override
    public GenericDao getGenericDao() {
        return horseDao;
    }

    @Override
    public Horse getByNickName(String nickName) {
        return horseDao.getByNickName(nickName);
    }

    @Transactional
    @Override
    public Long save(Horse horse) throws NullPointerException, IllegalArgumentException {
        Validate.notNull(horse.getNickName(),"Arguments NickName may not by null");
        Validate.notNull(horse.getEquipmentWeight(),"Arguments EquipmentWeight may not by null");
        Validate.notNull(horse.getOwner(),"Arguments Owner may not by null");
        Validate.notNull(horse.getAge(),"Arguments Age may not by null");
        Long horseId;
        if (horse.getId() == null) {
            Horse oldHorse = horseDao.getByNickName(horse.getNickName());
            if (oldHorse!=null)throw new IllegalArgumentException("NickName "+ horse.getNickName()+" already exists");
            horseId = horseDao.insert(horse);
        } else {
            horseDao.update(horse);
            horseId=horse.getId();
        }
        return horseId;
    }
}
