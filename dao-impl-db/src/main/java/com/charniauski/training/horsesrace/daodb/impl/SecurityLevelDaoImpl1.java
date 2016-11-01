package com.charniauski.training.horsesrace.daodb.impl;

import com.charniauski.training.horsesrace.daodb.SecurityLevelDao;
import com.charniauski.training.horsesrace.daodb.SecurityLevelDao1;
import com.charniauski.training.horsesrace.datamodel.AccountStatus;
import com.charniauski.training.horsesrace.datamodel.SecurityLevel;
import com.charniauski.training.horsesrace.datamodel.SecurityLevel1;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import java.util.Map;

import static com.charniauski.training.horsesrace.daodb.util.ReflectionUtil.getBean;
import static com.charniauski.training.horsesrace.daodb.util.SqlBuilder.sqlSelectEntity;
import static java.lang.String.format;

/**
 * Created by Andre on 19.10.2016.
 */
@Repository
public class SecurityLevelDaoImpl1 extends AbstractDao<SecurityLevel1,Long> implements SecurityLevelDao1 {

    @Override
    public SecurityLevel1 getSecurityLevel1(SecurityLevel1.AccountStatus1 accountStatus) {
        String status=accountStatus.name();
        String sql= format("%s WHERE client_status='%s';",sqlSelectEntity(SecurityLevel1.class),status);
        Map<String, Object> stringObjectMap;
        try {
            stringObjectMap = getJdbcTemplate().queryForMap(sql);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
        return getBean(stringObjectMap,SecurityLevel1.class);
    }
}
