package com.charniauski.training.horsesrace.services.impl;

import com.charniauski.training.horsesrace.daoapi.EventDao;
import com.charniauski.training.horsesrace.daoapi.GenericDao;
import com.charniauski.training.horsesrace.datamodel.Event;
import com.charniauski.training.horsesrace.datamodel.RaceDetail;
import com.charniauski.training.horsesrace.datamodel.enums.ResultEvent;
import com.charniauski.training.horsesrace.services.EventService;
import com.charniauski.training.horsesrace.services.RaceDetailService;
import com.charniauski.training.horsesrace.services.exception.NoSuchEntityException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

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
    public GenericDao<Event, Long> getGenericDao() {
        return eventDao;
    }

    @Transactional
    @Override
    public Long save(Event event){
//        Validate.notNull(event.getRaceDetailId(), "Arguments RaceDetailId may not by null");
//        Validate.notNull(event.getEventType(), "Arguments EventType may not by null");
//        Validate.notNull(event.getCoefficientEvent(), "Arguments CoefficientEvent may not by null");
//        Validate.notNull(event.getBookmaker(), "Arguments Bookmaker may not by null");
//        Validate.notNull(event.getResultEvent(), "Arguments ResultEvent may not by null");

        RaceDetail raceDetail =raceDetailService.get(event.getRaceDetailId());
        if (raceDetail == null) throw new NoSuchEntityException("RaceDetail not found. Enter valid id!");
        Long eventId;
        if (event.getId() == null) {
//            if (event.getResultEvent() != null) throw new IllegalArgumentException("ResultEvent must not be if insert");
            event.setDateRegister(new Timestamp(new Date().getTime()));
            eventId = eventDao.insert(event);
        } else {
            eventDao.update(event);
            eventId=event.getId();
        }
        return eventId;
    }

    @Override
    public List<Event> getAllByRaceDetail(Long raceDetail) {
        return eventDao.getAllByRaceDetail(raceDetail);
    }

    @Override
    public List<Event> getAllByResultEvent(ResultEvent resultEvent) {
        return eventDao.getAllByResultEvent(resultEvent);
    }

    @Override
    public List<Event> getAllByResultEventAndRaceDetail(ResultEvent resultEvent, Long raceDetail) {
        return eventDao.getAllByResultEventAndRaceDetail(resultEvent,raceDetail);
    }

    @Transactional
    @Override
    public void updateResultEvent(Long eventId, ResultEvent resultEvent) {
        Event event = get(eventId);
        event.setResultEvent(resultEvent);
        save(event);
    }
}
