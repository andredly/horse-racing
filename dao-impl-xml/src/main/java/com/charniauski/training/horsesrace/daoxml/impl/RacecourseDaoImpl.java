package com.charniauski.training.horsesrace.daoxml.impl;

import com.charniauski.training.horsesrace.daoapi.RacecourseDao;
import com.charniauski.training.horsesrace.datamodel.RaceCard;
import com.charniauski.training.horsesrace.datamodel.Racecourse;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Andre on 19.10.2016.
 */
@Repository
public class RacecourseDaoImpl extends AbstractDao<Racecourse,Long> implements RacecourseDao {

    private final AtomicLong sequence=new AtomicLong(0L);

    @Override
    public List<Racecourse> getAllAfterCurrentDate() {
        File fileRaceCard = new File(getBasePath() + "/" + RaceCard.class.getSimpleName() + ".xml");
        getXstream().alias(RaceCard.class.getSimpleName(), RaceCard.class);
        List<RaceCard> listRaceCard = new ArrayList<>((List<RaceCard>) getXstream().fromXML(fileRaceCard));
        Iterator<RaceCard> iteratorListRaceCard = listRaceCard.iterator();
        Date date = new Date();
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.add(Calendar.HOUR,24);
        while (iteratorListRaceCard.hasNext()) {
            RaceCard next = iteratorListRaceCard.next();
            if (next.getDateStart().before(date)||next.getDateStart().after(instance.getTime())) {
                iteratorListRaceCard.remove();
            }
        }
        Set<Racecourse> racecourseSet=new HashSet<>();
        for (RaceCard raceCard:listRaceCard){
            Long racecourseId = raceCard.getRacecourseId();
            racecourseSet.add(get(racecourseId));
        }
        return new ArrayList<>(racecourseSet);
    }

    @Override
    public Racecourse getByName(String name) {
        List<Racecourse> racecourses = readCollection();
        for (Racecourse racecourse:racecourses){
            if (racecourse.getName().equals(name)) {
                return racecourse;}
        }
        return null;
    }

    public Long next() {
        return sequence.incrementAndGet();
    }

    public AtomicLong getSequence() {
        return sequence;
    }
}
