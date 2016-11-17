package com.charniauski.training.horsesrace.daoxml.impl;


import com.charniauski.training.horsesrace.daoapi.HorseDao;
import com.charniauski.training.horsesrace.datamodel.Horse;
import com.charniauski.training.horsesrace.datamodel.RaceDetail;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Andre on 19.10.2016.
 */
@Repository
public class HorseDaoImpl extends AbstractDao<Horse,Long> implements HorseDao {

    private final AtomicLong sequence=new AtomicLong(1L);
    @Override
    public Horse getByNickName(String nickName) {
        try {
            return readCollection().stream().filter(hr -> hr.getNickName().equals(nickName)).findFirst().get();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    @Override
    public Horse getByRaceDetail(Long raceDetail) {
        File fileRaceDetail = new File(getBasePath() + "/" + RaceDetail.class.getSimpleName() + ".xml");
        getXstream().alias(RaceDetail.class.getSimpleName(), RaceDetail.class);
        List<RaceDetail> list = new ArrayList<>((List<RaceDetail>) getXstream().fromXML(fileRaceDetail));
        for (RaceDetail rd : list) {
            if (rd.getId().equals(raceDetail)) {
                return get(rd.getHorseId());
            }
        }
        return null;
    }


    public Long next() { return sequence.getAndIncrement(); }

    public AtomicLong getSequence() {
        return sequence;
    }
}
