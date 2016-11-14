package com.charniauski.training.horsesrace.daoxml.impl;

import com.charniauski.training.horsesrace.daoapi.RaceDetailDao;
import com.charniauski.training.horsesrace.datamodel.RaceCard;
import com.charniauski.training.horsesrace.datamodel.RaceDetail;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static com.charniauski.training.horsesrace.daoxml.util.SqlBuilder.sqlSelectEntity;
import static java.lang.String.format;

/**
 * Created by Andre on 19.10.2016.
 */
@Repository
public class RaceDetailDaoImpl extends AbstractDao<RaceDetail, Long> implements RaceDetailDao {

    private final AtomicLong sequence=new AtomicLong(0L);
    @Override
    public RaceDetail getByRaceCardAndHorse(Long raceCardId, Long horseId) {
        for (RaceDetail raceDetail:readCollection()){
            if (raceDetail.getRaceCardId().equals(raceCardId)&&raceDetail.getHorseId().equals(horseId)) {
                return  raceDetail;
            }
        }
        return null;
    }

    @Override
    public RaceDetail getByRaceCardAndCommand(Long raceCardId, Long commandId) {
        for (RaceDetail raceDetail:readCollection()){
            if (raceDetail.getRaceCardId().equals(raceCardId)&&raceDetail.getCommandId().equals(commandId)) {
                return  raceDetail;
            }
        }
        return null;
    }

    @Override
    public RaceDetail getByRaceCardAndNumberStartBox(Long raceCardId, Integer numberStartBox) {
        for (RaceDetail raceDetail:readCollection()){
            if (raceDetail.getRaceCardId().equals(raceCardId)&&raceDetail.getNumberStartBox().equals(numberStartBox)) {
                return  raceDetail;
            }
        }
        return null;
    }

    @Override
    public List<RaceDetail> getByRaceCard(Long raceCardId) {
        List<RaceDetail> list = readCollection();
        Iterator<RaceDetail> raceDetailIterator = list.iterator();
        while (raceDetailIterator.hasNext()) {
            RaceDetail next = raceDetailIterator.next();
            if (!next.getRaceCardId().equals(raceCardId)) {
                raceDetailIterator.remove();
            }
        }
        return list;
    }

    public Long next() {
        return sequence.incrementAndGet();
    }

    public AtomicLong getSequence() {
        return sequence;
    }

}
