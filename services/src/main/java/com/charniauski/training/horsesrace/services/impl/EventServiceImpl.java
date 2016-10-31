package com.charniauski.training.horsesrace.services.impl;

import com.charniauski.training.horsesrace.daodb.EventDao;
import com.charniauski.training.horsesrace.daodb.GenericDao;
import com.charniauski.training.horsesrace.datamodel.Event;
import com.charniauski.training.horsesrace.services.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by Andre on 19.10.2016.
 */
@Service
public class EventServiceImpl extends AbstractService<Event,Long> implements EventService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventServiceImpl.class);

    @Inject
    private EventDao eventDao;


    @Override
    public GenericDao getGenericDao() {
        return eventDao;
    }
}
