package com.charniauski.training.horsesrace.daodb.impl;

import com.charniauski.training.horsesrace.daodb.SecurityLevelDao;
import com.charniauski.training.horsesrace.datamodel.Command;
import com.charniauski.training.horsesrace.datamodel.SecurityLevel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Andre on 19.10.2016.
 */
@Repository
public class SecurityLevelDaoImpl extends AbstractDao<SecurityLevel,Long> {

    public SecurityLevelDaoImpl() {
        super(SecurityLevel.class);
    }
}
