package com.charniauski.training.horsesrace.services.impl;

import com.charniauski.training.horsesrace.daodb.GenericDao;
import com.charniauski.training.horsesrace.daodb.SecurityLevelDao1;
import com.charniauski.training.horsesrace.datamodel.SecurityLevel1;
import com.charniauski.training.horsesrace.services.SecurityLevelService1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by Andre on 19.10.2016.
 */
@Service
public class SecurityLevelServiceImpl1 extends AbstractService<SecurityLevel1,Long> implements SecurityLevelService1 {

    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityLevelServiceImpl1.class);

    @Inject
    private SecurityLevelDao1 securityLevelDao1;


    @Override
    public GenericDao getGenericDao() {
        return securityLevelDao1;
    }

    @Override
    public SecurityLevel1 getSecurityLevel1(SecurityLevel1.AccountStatus1 accountStatus) {
        return securityLevelDao1.getSecurityLevel1(accountStatus);
    }
}
