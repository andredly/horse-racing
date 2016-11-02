package com.charniauski.training.horsesrace.services.impl;

import com.charniauski.training.horsesrace.daodb.GenericDao;
import com.charniauski.training.horsesrace.daodb.RaceCardDao;
import com.charniauski.training.horsesrace.datamodel.RaceCard;
import com.charniauski.training.horsesrace.services.RaceCardService;
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
public class RaceCardServiceImpl extends AbstractService<RaceCard,Long> implements RaceCardService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RaceCardServiceImpl.class);
    @Inject
    private RaceCardDao raceCardDao;


    @Override
    public GenericDao getGenericDao() {
        return raceCardDao;
    }

    @Override
    public List<RaceCard> getAllAfterCurrentDate(Long racecourseId) {
        return raceCardDao.getAllByRacecourseAfterCurrentDate(racecourseId);
    }

    @Override
    public List<RaceCard> getThreeNextAfterCurrentDate() {
        List<RaceCard> allAfterCurrentDate = getAllAfterCurrentDate();
        List<RaceCard> threeNextAfterCurrentDate=new ArrayList<>();
        if (allAfterCurrentDate.isEmpty())return threeNextAfterCurrentDate;
        int size;
        if (allAfterCurrentDate.size()<=3)size=allAfterCurrentDate.size();
        else size=3;
        for (int i=0;i<size;i++){
            threeNextAfterCurrentDate.add(allAfterCurrentDate.get(i));
        }
        return threeNextAfterCurrentDate;
    }

    @Override
    public List<RaceCard> getAllAfterCurrentDate() {
        return raceCardDao.getAllAfterCurrentDate();
    }


}
