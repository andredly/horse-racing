package com.charniauski.training.horsesrace.services.impl;

import com.charniauski.training.horsesrace.daodb.GenericDao;
import com.charniauski.training.horsesrace.daodb.RacecourseDao;
import com.charniauski.training.horsesrace.daodb.SecurityLevelDao;
import com.charniauski.training.horsesrace.datamodel.AccountStatus;
import com.charniauski.training.horsesrace.datamodel.Racecourse;
import com.charniauski.training.horsesrace.datamodel.SecurityLevel;
import com.charniauski.training.horsesrace.services.RacecourseService;
import com.charniauski.training.horsesrace.services.SecurityLevelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by Andre on 19.10.2016.
 */
@Service
public class SecurityLevelServiceImpl extends AbstractService<SecurityLevel,Long> implements SecurityLevelService {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(SecurityLevelServiceImpl.class);

    @Inject
    private SecurityLevelDao securityLevelDao;


    @Override
    public GenericDao getGenericDao() {
        return securityLevelDao;
    }

    @Override
    public SecurityLevel getSecurityLevel(AccountStatus accountStatus) {
        return securityLevelDao.getSecurityLevel(accountStatus);
    }
}
