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
import java.util.ArrayList;
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
        return raceDetailDao.getByRaceCardAndCommand(raceCardId, commandId);
    }

    @Cached
    @Override
    public RaceDetail getByRaceCardAndNumberStartBox(Long raceCardId, Integer numberStartBox) {
        return raceDetailDao.getByRaceCardAndNumberStartBox(raceCardId, numberStartBox);
    }

    @Cached
    @Override
    public List<RaceDetail> getAllByRaceCard(Long raceCardId) {
        return raceDetailDao.getAllByRaceCard(raceCardId);
    }

    @Override
    public RaceDetailWrapper getAllDataForRaceDetail(Long raceDetailId) {
        RaceDetail raceDetail = get(raceDetailId);
        RaceDetailWrapper raceDetailWrapper = new RaceDetailWrapper();
        raceDetailWrapper.setHorse(horseService.get(raceDetail.getHorseId()));
        raceDetailWrapper.setCommand(commandService.get(raceDetail.getCommandId()));
        raceDetailWrapper.setEvents(eventService.getAllByRaceDetail(raceDetailId));
        raceDetailWrapper.setRaceDetail(raceDetail);
        return raceDetailWrapper;
    }

    @Override
    public List<RaceDetailWrapper> getAllDataForRaceCardAllRaceDetail(Long raceCardId) {
        List<RaceDetail> list = getAllByRaceCard(raceCardId);
        List<RaceDetailWrapper> raceDetailWrappers = new ArrayList<>();
        list.forEach(rd -> raceDetailWrappers.add(getAllDataForRaceDetail(rd.getId())));
        return raceDetailWrappers;
    }

    @Transactional
    @Override
    public Long save(RaceDetail raceDetail) {
//        validateDataRaceDetail(raceDetail);
        RaceCard raceCard = raceCardService.get(raceDetail.getRaceCardId());
        Horse horse = horseService.get(raceDetail.getHorseId());
        Command command = commandService.get(raceDetail.getCommandId());
        if (raceCard == null || horse == null || command == null)
            throw new NoSuchEntityException("RaceCardId or HorseId and CommandId not found. Enter valid id!");
        Long raceDetailId;
        if (raceDetail.getId() == null) {
            raceDetailId = raceDetailDao.insert(raceDetail);
        } else {
            raceDetailDao.update(raceDetail);
            raceDetailId = raceDetail.getId();
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
