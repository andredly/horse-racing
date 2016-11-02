package com.charniauski.training.horsesrace.daodb.impl;

import com.charniauski.training.horsesrace.daodb.GenericDao;
import com.charniauski.training.horsesrace.datamodel.AbstractModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;


import javax.inject.Inject;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.charniauski.training.horsesrace.daodb.util.ReflectionUtil.*;
import static com.charniauski.training.horsesrace.daodb.util.SqlBuilder.*;
import static java.lang.String.*;

/**
 * Created by ivc4 on 21.10.2016.
 */
@Repository
public abstract class AbstractDao<T extends AbstractModel, PK> implements GenericDao<T, PK> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractDao.class);

    @Inject
    private JdbcTemplate jdbcTemplate;

    private final Class<T> clazz;

    @SuppressWarnings("unchecked")
    protected AbstractDao() {
        this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }


    //    @SuppressWarnings("unchecked")
    @Override
    public T get(PK id) {
        String sql= format("%s WHERE id=%d;",sqlSelectEntity(clazz),id);
        LOGGER.debug(sql);
        T bean;
        try {
            bean = getBean(jdbcTemplate.queryForMap(sql), clazz);
        }catch (EmptyResultDataAccessException e){
        return null;
        }
        return bean;
    }

    @SuppressWarnings("unchecked")
    @Override
    public PK insert(T entity) {
        String sql = sqlInsertOrUpdateEntity(entity, true);
        LOGGER.debug(sql);
        KeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> con.prepareStatement(sql, new String[]{"id"}), generatedKeyHolder);
        return (PK) (Object) generatedKeyHolder.getKey().longValue();
    }

    //        @SuppressWarnings("unchecked")
    @Override
    public Long update(T entity) {
        String sql = sqlInsertOrUpdateEntity(entity, false);
        LOGGER.debug(sql);
        jdbcTemplate.update(sql);
        return null;
    }

//            @SuppressWarnings("unchecked")
    @Override
    public boolean delete(PK id) {
        String sql= format("%s%d;",sqlDeleteEntity(clazz),id);
        LOGGER.debug(sql);
        int delete = jdbcTemplate.update(sql);
        return delete == 1;
    }

    @Override
    public List<T> getAll() {
        List<T> listT = new ArrayList<>();
        List<Map<String, Object>> listMap = jdbcTemplate.queryForList(sqlSelectEntity(clazz));
        for (Map<String, Object> map : listMap) {
            T entity = getBean(map, clazz);
            listT.add(entity);
        }
        LOGGER.debug(listT.toString());
        return listT;
    }

    JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

}
