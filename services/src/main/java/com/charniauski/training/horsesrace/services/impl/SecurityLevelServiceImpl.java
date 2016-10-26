package com.charniauski.training.horsesrace.services.impl;

import com.charniauski.training.horsesrace.daodb.GenericDao;
import com.charniauski.training.horsesrace.daodb.RacecourseDao;
import com.charniauski.training.horsesrace.daodb.SecurityLevelDao;
import com.charniauski.training.horsesrace.datamodel.Racecourse;
import com.charniauski.training.horsesrace.datamodel.SecurityLevel;
import com.charniauski.training.horsesrace.services.RacecourseService;
import com.charniauski.training.horsesrace.services.SecurityLevelService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by Andre on 19.10.2016.
 */
@Service
public class SecurityLevelServiceImpl extends AbstractService<SecurityLevel,Long> implements SecurityLevelService {


    @Inject
    private SecurityLevelDao securityLevelDao;


    @Override
    public GenericDao getGenericDao() {
        return securityLevelDao;
    }
}
