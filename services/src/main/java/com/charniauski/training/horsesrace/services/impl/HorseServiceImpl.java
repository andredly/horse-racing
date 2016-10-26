package com.charniauski.training.horsesrace.services.impl;

import com.charniauski.training.horsesrace.daodb.EventDao;
import com.charniauski.training.horsesrace.daodb.GenericDao;
import com.charniauski.training.horsesrace.daodb.HorseDao;
import com.charniauski.training.horsesrace.datamodel.Event;
import com.charniauski.training.horsesrace.datamodel.Horse;
import com.charniauski.training.horsesrace.services.EventService;
import com.charniauski.training.horsesrace.services.HorseService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by Andre on 19.10.2016.
 */
@Service
public class HorseServiceImpl extends AbstractService<Horse,Long> implements HorseService {


    @Inject
    private HorseDao horseDao;


    @Override
    public GenericDao getGenericDao() {
        return horseDao;
    }
}
