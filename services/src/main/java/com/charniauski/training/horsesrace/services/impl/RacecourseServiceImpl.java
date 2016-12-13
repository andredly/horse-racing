package com.charniauski.training.horsesrace.services.impl;

import com.charniauski.training.horsesrace.daoapi.GenericDao;
import com.charniauski.training.horsesrace.daoapi.RacecourseDao;
import com.charniauski.training.horsesrace.datamodel.RaceCard;
import com.charniauski.training.horsesrace.datamodel.Racecourse;
import com.charniauski.training.horsesrace.services.RaceCardService;
import com.charniauski.training.horsesrace.services.RacecourseService;
import com.charniauski.training.horsesrace.services.cacherequest.Cached;
import com.charniauski.training.horsesrace.services.wrapper.RaceCardWrapper;
import com.charniauski.training.horsesrace.services.wrapper.RacecourseWrapper;
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
public class RacecourseServiceImpl extends AbstractService<Racecourse, Long> implements RacecourseService {
    private static final Logger LOGGER = LoggerFactory.getLogger(RacecourseServiceImpl.class);

    @Inject
    private RacecourseDao racecourseDao;

    @Inject
    private RaceCardService raceCardService;


    @Override
    public GenericDao<Racecourse, Long> getGenericDao() {
        return racecourseDao;
    }

    @Cached(timeToLiveSeconds = 60)
    @Override
    public List<Racecourse> getAllAfterCurrentDate() {
        return racecourseDao.getAllAfterCurrentDate();
    }


    @Cached
    @Override
    public Racecourse getByName(String name) {
        return racecourseDao.getByName(name);
    }

    @Override
    public RacecourseWrapper getAllDataForRacecourseWithRaceCardsAfterCurrentDate(Long racecourseId) {
        RacecourseWrapper racecourseWrapper = new RacecourseWrapper();
        racecourseWrapper.setRaceCards(raceCardService.getAllByRacecourseAfterCurrentDate(racecourseId));
        racecourseWrapper.setRacecourse(get(racecourseId));
        return racecourseWrapper;
    }

    @Override
    public List<RacecourseWrapper> getAllRacecourseWithRaceCardsAfterCurrentDate() {
        List<Racecourse> list = getAllAfterCurrentDate();
        List<RacecourseWrapper> racecourseWrappers = new ArrayList<>();
        list.forEach(rc -> racecourseWrappers.add(getAllDataForRacecourseWithRaceCardsAfterCurrentDate(rc.getId())));
        return racecourseWrappers;
    }


    @Transactional
    @Override
    public Long save(Racecourse racecourse) {
        Long racecourseId;
        if (racecourse.getId() == null) {
            Racecourse oldRacecourse = racecourseDao.getByName(racecourse.getName());
            if (oldRacecourse != null)
                throw new IllegalArgumentException("Name " + racecourse.getName() + " already exists");
            racecourseId = racecourseDao.insert(racecourse);
        } else {
            racecourseDao.update(racecourse);
            racecourseId = racecourse.getId();
        }
        return racecourseId;
    }
}
