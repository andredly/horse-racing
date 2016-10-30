package com.charniauski.training.horsesrace.services.impl;

import com.charniauski.training.horsesrace.daodb.GenericDao;
import com.charniauski.training.horsesrace.daodb.RacecourseDao;
import com.charniauski.training.horsesrace.datamodel.Racecourse;
import com.charniauski.training.horsesrace.services.RacecourseService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Andre on 19.10.2016.
 */
@Service
public class RacecourseServiceImpl extends AbstractService<Racecourse,Long> implements RacecourseService {


    @Inject
    private RacecourseDao racecourseDao;


    @Override
    public GenericDao getGenericDao() {
        return racecourseDao;
    }

    @Override
    public List<Racecourse> getAllByCurrentDate() {
        return racecourseDao.getAllAfterCurrentDate();
    }
}
