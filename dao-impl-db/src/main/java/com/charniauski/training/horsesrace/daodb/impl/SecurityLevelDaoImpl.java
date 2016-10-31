package com.charniauski.training.horsesrace.daodb.impl;

import com.charniauski.training.horsesrace.daodb.SecurityLevelDao;
import com.charniauski.training.horsesrace.datamodel.AccountStatus;
import com.charniauski.training.horsesrace.datamodel.Racecourse;
import com.charniauski.training.horsesrace.datamodel.SecurityLevel;
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
public class SecurityLevelDaoImpl extends AbstractDao<SecurityLevel,Long> implements SecurityLevelDao{

    @Override
    public SecurityLevel getSecurityLevel(AccountStatus accountStatus) {
        String status=accountStatus.name();
        String sql= format("%s WHERE client_status='%s';",sqlSelectEntity(SecurityLevel.class),status);
        Map<String, Object> stringObjectMap;
        try {
            stringObjectMap = getJdbcTemplate().queryForMap(sql);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
        return getBean(stringObjectMap,SecurityLevel.class);
    }
}
