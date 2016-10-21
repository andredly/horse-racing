package com.charniauski.training.horsesrace.daodb;

import com.charniauski.training.horsesrace.datamodel.SecurityLevel;

import java.util.List;

/**
 * Created by Andre on 19.10.2016.
 */
public interface SecurityLevelDao extends GenericDao<SecurityLevel,Long>{

    List<SecurityLevel> getAll();
}
