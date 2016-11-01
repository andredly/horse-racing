package com.charniauski.training.horsesrace.daodb;

import com.charniauski.training.horsesrace.datamodel.AccountStatus;
import com.charniauski.training.horsesrace.datamodel.SecurityLevel;
import com.charniauski.training.horsesrace.datamodel.SecurityLevel1;

/**
 * Created by Andre on 19.10.2016.
 */
public interface SecurityLevelDao1 extends GenericDao<SecurityLevel1,Long>{

    SecurityLevel1 getSecurityLevel1(SecurityLevel1.AccountStatus1 accountStatus);

}
