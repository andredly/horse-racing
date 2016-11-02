package com.charniauski.training.horsesrace.services.impl;

import com.charniauski.training.horsesrace.daodb.GenericDao;
import com.charniauski.training.horsesrace.daodb.HorseDao;
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
}
