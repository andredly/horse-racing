package com.charniauski.training.horsesrace.services;

import com.charniauski.training.horsesrace.datamodel.AccountStatus;
import com.charniauski.training.horsesrace.datamodel.SecurityLevel;
import com.charniauski.training.horsesrace.datamodel.SecurityLevel1;

/**
 * Created by Andre on 18.10.2016.
 */
public interface SecurityLevelService1 extends GenericService<SecurityLevel1,Long> {

    SecurityLevel1 getSecurityLevel1(SecurityLevel1.AccountStatus1 accountStatus);

}
