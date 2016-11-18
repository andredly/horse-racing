package com.charniauski.training.horsesrace.daoxml.impl;

import com.charniauski.training.horsesrace.daoapi.RacecourseDao;
import com.charniauski.training.horsesrace.datamodel.RaceCard;
import com.charniauski.training.horsesrace.datamodel.Racecourse;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * Created by Andre on 19.10.2016.
 */
@Repository
public class RacecourseDaoImpl extends AbstractDao<Racecourse,Long> implements RacecourseDao {

    private final AtomicLong sequence=new AtomicLong(1L);

    @SuppressWarnings("unchecked")
    @Override
    public List<Racecourse> getAllAfterCurrentDate() {
        File fileRaceCard = new File(getBasePath() + "/" + RaceCard.class.getSimpleName() + ".xml");
        getXstream().alias(RaceCard.class.getSimpleName(), RaceCard.class);
        List<RaceCard> listRaceCard = new ArrayList<>((List<RaceCard>) getXstream().fromXML(fileRaceCard));
        Date date = new Date();
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.add(Calendar.HOUR,24);
        List<Racecourse> racecourses=new ArrayList<>();
        listRaceCard.stream().filter(raceCard->raceCard.getDateStart().after(date)
                &&raceCard.getDateStart().before(instance.getTime())).collect(Collectors.toList())
                .forEach(raceCard -> racecourses.add(get(raceCard.getRacecourseId())));
        return racecourses.stream().distinct().collect(Collectors.toList());
    }

    @Override
    public Racecourse getByName(String name) {
        return readCollection().stream().filter(rc -> rc.getName().equals(name)).findFirst().orElse(null);
    }

    public Long next() { return sequence.getAndIncrement(); }

    public AtomicLong getSequence() {
        return sequence;
    }
}
