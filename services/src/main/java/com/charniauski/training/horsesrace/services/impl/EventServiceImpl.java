package com.charniauski.training.horsesrace.services.impl;

import com.charniauski.training.horsesrace.daodb.EventDao;
import com.charniauski.training.horsesrace.daodb.GenericDao;
import com.charniauski.training.horsesrace.datamodel.Event;
import com.charniauski.training.horsesrace.datamodel.RaceDetail;
import com.charniauski.training.horsesrace.services.EventService;
import com.charniauski.training.horsesrace.services.RaceDetailService;
import com.charniauski.training.horsesrace.services.exception.NoSuchEntityException;
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
public class EventServiceImpl extends AbstractService<Event,Long> implements EventService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventServiceImpl.class);

    @Inject
    private EventDao eventDao;

    @Inject
    private RaceDetailService raceDetailService;


    @Override
    public GenericDao getGenericDao() {
        return eventDao;
    }

    @Transactional
    @Override
    public Long save(Event event){
        Validate.notNull(event.getRaceDetailId(), "Arguments RaceDetailId may not by null");
        Validate.notNull(event.getEventType(), "Arguments EventType may not by null");
        Validate.notNull(event.getDateRegister(), "Arguments DateRegister may not by null");
        Validate.notNull(event.getCoefficientEvent(), "Arguments CoefficientEvent may not by null");
        Validate.notNull(event.getBookmaker(), "Arguments Bookmaker may not by null");
        Validate.notNull(event.getResultEvent(), "Arguments ResultEvent may not by null");


        RaceDetail raceDetail =raceDetailService.get(event.getRaceDetailId());
        if (raceDetail == null) throw new NoSuchEntityException("RaceDetail not found. Enter valid id!");
        Long eventId;
        if (event.getId() == null) {
            if (event.getResultEvent() != null)
                throw new IllegalArgumentException("ResultEvent must not be if insert");
            eventId = eventDao.insert(event);
        } else {
            eventDao.update(event);
            eventId=event.getId();
        }
        return eventId;
    }
}
