package com.charniauski.training.horsesrace.services.impl;


import com.charniauski.training.horsesrace.daoapi.GenericDao;
import com.charniauski.training.horsesrace.daoapi.RaceDetailDao;
import com.charniauski.training.horsesrace.datamodel.*;
import com.charniauski.training.horsesrace.services.*;
import com.charniauski.training.horsesrace.services.cacherequest.Cached;
import com.charniauski.training.horsesrace.services.exception.NoSuchEntityException;
import com.charniauski.training.horsesrace.services.wrapper.RaceDetailWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Andre on 19.10.2016.
 */
@Service
public class RaceDetailServiceImpl extends AbstractService<RaceDetail, Long> implements RaceDetailService {
    private static final Logger LOGGER = LoggerFactory.getLogger(RaceDetailServiceImpl.class);

    @Inject
    private RaceDetailDao raceDetailDao;

    @Inject
    private RaceCardService raceCardService;

    @Inject
    private HorseService horseService;

    @Inject
    private CommandService commandService;

    @Inject
    private EventService eventService;

    @Override
    public GenericDao<RaceDetail, Long> getGenericDao() {
        return raceDetailDao;
    }

    @Cached
    @Override
    public RaceDetail getByRaceCardAndHorse(Long raceCardId, Long horseId) {
        return raceDetailDao.getByRaceCardAndHorse(raceCardId, horseId);
    }

    @Cached
    @Override
    public RaceDetail getByRaceCardAndCommand(Long raceCardId, Long commandId) {
        return raceDetailDao.getByRaceCardAndCommand(raceCardId,commandId);
    }

    @Cached
    @Override
    public RaceDetail getByRaceCardAndNumberStartBox(Long raceCardId, Integer numberStartBox) {
        return raceDetailDao.getByRaceCardAndNumberStartBox(raceCardId,numberStartBox);
    }

    @Cached
    @Override
    public List<RaceDetail> getAllByRaceCard(Long raceCardId) {
        return raceDetailDao.getAllByRaceCard(raceCardId);
    }

    @Override
    public RaceDetailWrapper getRaceDetailWrapper(Long raceDetailId) {
        RaceDetail raceDetail = get(raceDetailId);
        Horse horse=horseService.get(raceDetail.getHorseId());
        Command command=commandService.get(raceDetail.getCommandId());
        List<Event> events=eventService.getAllByRaceDetail(raceDetailId);
        RaceCard raceCard=raceCardService.get(raceDetail.getRaceCardId());
        RaceDetailWrapper raceDetailWrapper=new RaceDetailWrapper();
        raceDetailWrapper.setRaceCard(raceCard);
        raceDetailWrapper.setHorse(horse);
        raceDetailWrapper.setCommand(command);
        raceDetailWrapper.setEvents(events);
        raceDetailWrapper.setRaceDetail(raceDetail);
        return raceDetailWrapper;
    }

    @Override
    public RaceDetailWrapper getAllDataForRaceDetail(Long raceDetailId) {
        return getRaceDetailWrapper(raceDetailId);
    }

    @Transactional
    @Override
    public Long save(RaceDetail raceDetail)  {
//        validateDataRaceDetail(raceDetail);
        RaceCard raceCard = raceCardService.get(raceDetail.getRaceCardId());
        Horse horse =horseService.get(raceDetail.getHorseId());
        Command command =commandService.get(raceDetail.getCommandId());
        if (raceCard == null||horse==null||command==null)
            throw new NoSuchEntityException("RaceCardId or HorseId and CommandId not found. Enter valid id!");
        Long raceDetailId;
        if (raceDetail.getId() == null) {
            raceDetailId = raceDetailDao.insert(raceDetail);
        } else {
            raceDetailDao.update(raceDetail);
            raceDetailId=raceDetail.getId();
        }
        return raceDetailId;
    }

//    private void validateDataRaceDetail(RaceDetail raceDetail) {
//        Validate.notNull(raceDetail.getRaceCardId(), "Arguments RaceCardId may not by null");
//        Validate.notNull(raceDetail.getHorseId(), "Arguments HorseId may not by null");
//        Validate.notNull(raceDetail.getCommandId(), "Arguments CommandId may not by null");
//        Validate.notNull(raceDetail.getNumberStartBox(), "Arguments NumberStartBox may not by null");
//    }

}
