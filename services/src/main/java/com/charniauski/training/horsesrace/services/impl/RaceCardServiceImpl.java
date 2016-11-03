package com.charniauski.training.horsesrace.services.impl;

import com.charniauski.training.horsesrace.daodb.GenericDao;
import com.charniauski.training.horsesrace.daodb.RaceCardDao;
import com.charniauski.training.horsesrace.datamodel.RaceCard;
import com.charniauski.training.horsesrace.datamodel.RaceCard;
import com.charniauski.training.horsesrace.datamodel.Racecourse;
import com.charniauski.training.horsesrace.services.RaceCardService;
import com.charniauski.training.horsesrace.services.RacecourseService;
import com.charniauski.training.horsesrace.services.exception.NoSuchEntityException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andre on 19.10.2016.
 */
@Service
public class RaceCardServiceImpl extends AbstractService<RaceCard, Long> implements RaceCardService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RaceCardServiceImpl.class);
    @Inject
    private RaceCardDao raceCardDao;

    @Inject
    private RacecourseService racecourseService;


    @Override
    public GenericDao getGenericDao() {
        return raceCardDao;
    }

    @Override
    public List<RaceCard> getAllByRacecourseAfterCurrentDate(Long racecourseId) {
        return raceCardDao.getAllByRacecourseAfterCurrentDate(racecourseId);
    }

    @Override
    public List<RaceCard> getThreeNextAfterCurrentDate() {
        List<RaceCard> allAfterCurrentDate = getAllAfterCurrentDate();
        List<RaceCard> threeNextAfterCurrentDate = new ArrayList<>();
        if (allAfterCurrentDate.isEmpty()) return threeNextAfterCurrentDate;
        int size;
        if (allAfterCurrentDate.size() <= 3) size = allAfterCurrentDate.size();
        else size = 3;
        for (int i = 0; i < size; i++) {
            threeNextAfterCurrentDate.add(allAfterCurrentDate.get(i));
        }
        return threeNextAfterCurrentDate;
    }

    @Override
    public List<RaceCard> getAllAfterCurrentDate() {
        return raceCardDao.getAllAfterCurrentDate();
    }

    @Override
    public Long save(RaceCard raceCard) throws NullPointerException, IllegalArgumentException, NoSuchEntityException {
        if (raceCard.getRacecourseId() == null || raceCard.getDateStart() == null || raceCard.getRaceType() == null)
            throw new NullPointerException(String.format("Arguments may not by null: RacecourseId=%d, DateStart=%tB" +" DateFinish=%tB, RaceType=%s",
                    raceCard.getRacecourseId(), raceCard.getDateStart(), raceCard.getDateFinish(), raceCard.getRaceType()));
        Racecourse racecourse = racecourseService.get(raceCard.getRacecourseId());
        if (racecourse.getId() == null)
            throw new NoSuchEntityException("RacecourseId " + raceCard.getRacecourseId() + " not found. Enter valid id!");
        Long raceCardId = null;
        if (raceCard.getId() == null) {
            if (raceCard.getDateFinish() != null) throw new IllegalArgumentException("Date Finish must not be if insert");
            raceCardId = raceCardDao.insert(raceCard);
        } else {
            raceCardDao.update(raceCard);
            raceCardId=raceCard.getId();
        }
        return raceCardId;
    }
}
