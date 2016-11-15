package com.charniauski.training.horsesrace.daodb.impl;

import com.charniauski.training.horsesrace.daoapi.GenericDao;
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

import static com.charniauski.training.horsesrace.daodb.util.ReflectionUtil.getBean;
import static com.charniauski.training.horsesrace.daodb.util.SqlBuilder.*;
import static java.lang.String.format;

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
        this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }


    @Override
    public T get(PK id) {
        String sql = format("%s WHERE id=%d;", sqlSelectEntity(clazz), id);
        LOGGER.debug(sql);
        return getEntity(sql, clazz);
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

    @Override
    public Integer update(T entity) {
        String sql = sqlInsertOrUpdateEntity(entity, false);
        LOGGER.debug(sql);
        return jdbcTemplate.update(sql);
    }

    @Override
    public boolean delete(PK id) {
        String sql = format("%s%d;", sqlDeleteEntity(clazz), id);
        return jdbcTemplate.update(sql) == 1;
    }

    @Override
    public List<T> getAll() {
        String sql = sqlSelectEntity(clazz);
        LOGGER.debug(sql);
        return getListEntity(sql, clazz);
    }

    final T getEntity(String sql, Class<T> clazz) {
        T entity;
        try {
            entity = getBean(jdbcTemplate.queryForMap(sql), clazz);
        } catch (EmptyResultDataAccessException e) {
            LOGGER.error("Not found entity",e);
            return null;
        }
        LOGGER.debug(entity.toString());
        return entity;
    }

    final List<T> getListEntity(String sql, Class<T> clazz) {
        List<T> listT = new ArrayList<>();
        List<Map<String, Object>> listMap = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> map : listMap) {
            T entity = getBean(map, clazz);
            listT.add(entity);
        }
        return listT;
    }

    JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
}
