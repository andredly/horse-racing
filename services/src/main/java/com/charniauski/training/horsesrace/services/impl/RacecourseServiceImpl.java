package com.charniauski.training.horsesrace.services.impl;

import com.charniauski.training.horsesrace.daodb.GenericDao;
import com.charniauski.training.horsesrace.daodb.RacecourseDao;
import com.charniauski.training.horsesrace.datamodel.RaceCard;
import com.charniauski.training.horsesrace.datamodel.Racecourse;
import com.charniauski.training.horsesrace.services.RaceCardService;
import com.charniauski.training.horsesrace.services.RacecourseService;
import com.charniauski.training.horsesrace.services.wrapper.RacecourseWithListRaceCard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Andre on 19.10.2016.
 */
@Service
public class RacecourseServiceImpl extends AbstractService<Racecourse,Long> implements RacecourseService {
    private static final Logger LOGGER = LoggerFactory.getLogger(RacecourseServiceImpl.class);

    @Inject
    private RacecourseDao racecourseDao;

    @Inject
    private RaceCardService raceCardService;


    @Override
    public GenericDao getGenericDao() {
        return racecourseDao;
    }

    @Override
    public List<Racecourse> getAllAfterCurrentDate() {
        return racecourseDao.getAllAfterCurrentDate();
    }

    @Override
    public RacecourseWithListRaceCard getRacecourseWithListRaceCard(Long racecourseId) {
        Racecourse racecourse = get(racecourseId);
        List<RaceCard> raceCards=raceCardService.getAllRaceCardAfterCurrentDate(racecourseId);
        RacecourseWithListRaceCard racecourseWithListRaceCard=new RacecourseWithListRaceCard();
        racecourseWithListRaceCard.setRacecourse(racecourse);
        racecourseWithListRaceCard.setRaceCardList(raceCards);
        return racecourseWithListRaceCard;
    }

    @Override
    public Racecourse getRacecourseByName(String name) {
        return racecourseDao.getRacecourseByName(name);
    }
}
