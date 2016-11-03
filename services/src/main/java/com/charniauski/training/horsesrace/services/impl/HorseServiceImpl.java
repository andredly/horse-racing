package com.charniauski.training.horsesrace.services.impl;

import com.charniauski.training.horsesrace.daodb.GenericDao;
import com.charniauski.training.horsesrace.daodb.HorseDao;
import com.charniauski.training.horsesrace.datamodel.Account;
import com.charniauski.training.horsesrace.datamodel.Horse;
import com.charniauski.training.horsesrace.services.HorseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

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

    @Override
    public Long save(Horse horse) throws NullPointerException, IllegalArgumentException {
        if (horse.getAge() == null || horse.getNickName() == null || horse.getEquipmentWeight() == null || horse.getOwner() == null)
            throw new NullPointerException(String.format("Arguments may not by null: Age=%s, NickName=%s, NickName=%d," +
                    "Owner=%s", horse.getAge(), horse.getNickName(), horse.getEquipmentWeight(),horse.getOwner()));
        Long horseId = null;
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
