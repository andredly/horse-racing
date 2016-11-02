package com.charniauski.training.horsesrace.daodb.impl;

import com.charniauski.training.horsesrace.daodb.HorseDao;
import com.charniauski.training.horsesrace.datamodel.Account;
import com.charniauski.training.horsesrace.datamodel.Horse;
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
public class HorseDaoImpl extends AbstractDao<Horse,Long> implements HorseDao{

    @Override
    public Horse getByNickName(String nickName) {
        String sql = format("%s WHERE nick_name='%s';", sqlSelectEntity(Horse.class), nickName);
        Map<String, Object> stringObjectMap;
        Horse bean;
        try {
            stringObjectMap = getJdbcTemplate().queryForMap(sql);
            bean = getBean(stringObjectMap, Horse.class);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
        return bean;
    }
}
