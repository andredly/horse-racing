package com.charniauski.training.horsesrace.daoxml.impl;

import com.charniauski.training.horsesrace.daoapi.RaceCardDao;
import com.charniauski.training.horsesrace.datamodel.Event;
import com.charniauski.training.horsesrace.datamodel.RaceCard;
import com.charniauski.training.horsesrace.datamodel.RaceDetail;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * Created by Andre on 19.10.2016.
 */
@Repository
public class RaceCardDaoImpl extends AbstractDao<RaceCard,Long> implements RaceCardDao {


    private final AtomicLong sequence=new AtomicLong(1L);

    @Override
    public List<RaceCard> getAllByRacecourseAfterCurrentDate(Long racecourseId) {
        Date date = new Date();
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.add(Calendar.HOUR,24);
        return readCollection().stream().filter(rc->rc.getDateStart().after(date)
                &&rc.getDateStart().before(instance.getTime())
                &&rc.getRacecourseId().equals(racecourseId)).collect(Collectors.toList());
    }


    @SuppressWarnings("unchecked")
    @Override
    public RaceCard getByEvent(Long eventId) {
        File fileEvent = new File(getBasePath() + "/" + Event.class.getSimpleName() + ".xml");
        getXstream().alias(Event.class.getSimpleName(), Event.class);
        List<Event> eventList = new ArrayList<>((List<Event>) getXstream().fromXML(fileEvent));
        Event event=eventList.stream().filter(ev->ev.getId().equals(eventId)).findFirst().orElse(null);
        File fileRaceDetail = new File(getBasePath() + "/" + RaceDetail.class.getSimpleName() + ".xml");
        getXstream().alias(RaceDetail.class.getSimpleName(), RaceDetail.class);
        List<RaceDetail> list = new ArrayList<>((List<RaceDetail>) getXstream().fromXML(fileRaceDetail));
        RaceDetail raceDetail=list.stream().filter(rd->rd.getId().equals(event.getRaceDetailId())).findFirst().orElse(null);
        return get(raceDetail.getRaceCardId());
    }

    public Long next() { return sequence.getAndIncrement(); }

    public AtomicLong getSequence() {
        return sequence;
    }

}
