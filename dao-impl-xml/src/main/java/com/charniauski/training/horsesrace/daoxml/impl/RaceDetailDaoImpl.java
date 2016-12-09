package com.charniauski.training.horsesrace.daoxml.impl;

import com.charniauski.training.horsesrace.daoapi.RaceDetailDao;
import com.charniauski.training.horsesrace.datamodel.RaceDetail;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * Created by Andre on 19.10.2016.
 */
@Repository
public class RaceDetailDaoImpl extends AbstractDao<RaceDetail, Long> implements RaceDetailDao {

    private final AtomicLong sequence = new AtomicLong(1L);

    @Override
    public RaceDetail getByRaceCardAndHorse(Long raceCardId, Long horseId) {
        return readCollection().stream().filter(raceDetail -> raceDetail.getRaceCardId().equals(raceCardId)
                && raceDetail.getHorseId().equals(horseId)).findFirst().orElse(null);
    }

    @Override
    public RaceDetail getByRaceCardAndCommand(Long raceCardId, Long commandId) {
        return readCollection().stream().filter(raceDetail -> raceDetail.getRaceCardId().equals(raceCardId)
                && raceDetail.getCommandId().equals(commandId)).findFirst().orElse(null);
    }

    @Override
    public RaceDetail getByRaceCardAndNumberStartBox(Long raceCardId, Integer numberStartBox) {
        return readCollection().stream().filter(raceDetail -> raceDetail.getRaceCardId().equals(raceCardId)
                && raceDetail.getNumberStartBox().equals(numberStartBox)).findFirst().orElse(null);
    }

    @Override
    public List<RaceDetail> getAllByRaceCard(Long raceCardId) {
        return readCollection().stream().filter(raceDetail -> raceDetail.getRaceCardId().equals(raceCardId))
                .collect(Collectors.toList());
    }

    public Long next() {
        return sequence.getAndIncrement();
    }

    public AtomicLong getSequence() {
        return sequence;
    }

}
