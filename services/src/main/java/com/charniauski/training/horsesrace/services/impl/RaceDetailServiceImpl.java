package com.charniauski.training.horsesrace.services.impl;

import com.charniauski.training.horsesrace.daodb.GenericDao;
import com.charniauski.training.horsesrace.daodb.RaceDetailDao;
import com.charniauski.training.horsesrace.datamodel.*;
import com.charniauski.training.horsesrace.services.CommandService;
import com.charniauski.training.horsesrace.services.HorseService;
import com.charniauski.training.horsesrace.services.RaceCardService;
import com.charniauski.training.horsesrace.services.RaceDetailService;
import com.charniauski.training.horsesrace.services.exception.NoSuchEntityException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

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

    @Override
    public GenericDao getGenericDao() {
        return raceDetailDao;
    }

    @Override
    public boolean saveHorseResult(Long raceCardId, Long horseId, Integer result) throws IllegalArgumentException, NoSuchEntityException{

        //// TODO: 03.11.2016  проверить сохранение

        RaceDetail oldRaceDetail = getByRaceCardAndHorse(raceCardId, horseId);
        if (oldRaceDetail == null) throw new IllegalArgumentException();
        oldRaceDetail.setHorseResult(result);
        Long saveId = save(oldRaceDetail);
        return saveId != null;
    }

    @Override
    public RaceDetail getByRaceCardAndHorse(Long raceCardId, Long horseId) {
        return raceDetailDao.getByRaceCardAndHorse(raceCardId, horseId);
    }

    @Override
    public RaceDetail getByRaceCardAndCommand(Long raceCardId, Long commandId) {
        return raceDetailDao.getByRaceCardAndCommand(raceCardId,commandId);
    }

    @Override
    public RaceDetail getByRaceCardAndNumberStartBox(Long raceCardId, Integer numberStartBox) {
        return raceDetailDao.getByRaceCardAndNumberStartBox(raceCardId,numberStartBox);
    }

    @Override
    public Long save(RaceDetail raceDetail) throws NullPointerException, IllegalArgumentException, NoSuchEntityException {
        if (raceDetail.getRaceCardId() == null || raceDetail.getHorseId() == null || raceDetail.getCommandId() == null
                || raceDetail.getNumberStartBox()==null)
            throw new NullPointerException(String.format("Arguments may not by null: RaceCardId=%d, HorseId=%d" +" CommandId=%d, NumberStartBox=%d",
                    raceDetail.getRaceCardId(), raceDetail.getHorseId(), raceDetail.getCommandId(), raceDetail.getNumberStartBox()));

//        RaceDetail raceCardAndHorse =getByRaceCardAndHorse(raceDetail.getRaceCardId(),raceDetail.getHorseId());
//        if(raceCardAndHorse!=null) throw  new IllegalArgumentException("Combination RaceCard and Horse there");
//        RaceDetail raceCardAndCommand =getByRaceCardAndCommand(raceDetail.getRaceCardId(),raceDetail.getCommandId());
//        if(raceCardAndCommand!=null) throw  new IllegalArgumentException("Combination RaceCard and Command there");
//        RaceDetail raceCardAndNumberStartBox =getByRaceCardAndNumberStartBox(raceDetail.getRaceCardId(),raceDetail.getNumberStartBox());
//        if(raceCardAndNumberStartBox!=null) throw  new IllegalArgumentException("Combination RaceCard and NumberStartBox there");

        RaceCard raceCard = raceCardService.get(raceDetail.getRaceCardId());
        Horse horse =horseService.get(raceDetail.getHorseId());
        Command command =commandService.get(raceDetail.getCommandId());
        if (raceCard == null||horse==null||command==null)
            throw new NoSuchEntityException("RaceCardId or HorseId and CommandId not found. Enter valid id!");
        Long raceDetailId = null;
        if (raceDetail.getId() == null) {
            if (raceDetail.getHorseResult() != null)
                throw new IllegalArgumentException("Horse result must not be if insert");
            raceDetailId = raceDetailDao.insert(raceDetail);
        } else {
            raceDetailDao.update(raceDetail);
            raceDetailId=raceDetail.getId();
        }
        return raceDetailId;
    }

}
