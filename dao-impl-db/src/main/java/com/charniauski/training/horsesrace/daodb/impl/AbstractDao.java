package com.charniauski.training.horsesrace.daodb.impl;

import com.charniauski.training.horsesrace.daodb.GenericDao;
import com.charniauski.training.horsesrace.datamodel.AbstractModel;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
import static com.charniauski.training.horsesrace.daodb.util.SqlUtil.*;

/**
 * Created by ivc4 on 21.10.2016.
 */
@Repository
public abstract class AbstractDao<T extends AbstractModel, PK> implements GenericDao<T, PK> {

    @Inject
    private JdbcTemplate jdbcTemplate;

    private final Class<T> clazz;

    protected AbstractDao(Class<T> clazz) {
        this.clazz = clazz;
    }



    //    @SuppressWarnings("unchecked")
    @Override
    public T get(PK id) {
        String sql = sqlSelectEntity(clazz);
        sql = sql + "WHERE id =?;";
        System.out.println(sql);

        return jdbcTemplate.queryForObject(
                sql,
                new Object[]{id}, new BeanPropertyRowMapper<>(clazz));
    }

    //    @SuppressWarnings("unchecked")
    @Override
    public PK insert(T entity) {
        String sql = sqlInsertOrUpdateEntity(entity, true);
        System.out.println(sql);
        KeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> con.prepareStatement(sql, new String[]{"id"}), generatedKeyHolder);
        Object id = generatedKeyHolder.getKey().longValue();
        return (PK) id;
    }

    //        @SuppressWarnings("unchecked")
    @Override
    public void update(T entity) {
        String sql = sqlInsertOrUpdateEntity(entity, false);
        sql = sql + " id=" + entity.getId();
        System.out.println(sql);
        jdbcTemplate.update(sql);
    }

    //        @SuppressWarnings("unchecked")
    @Override
    public boolean delete(PK id) {
        String sql = sqlDeleteEntity(clazz);
        sql = sql + " id=" + id;
        System.out.println(sql);
        int delete = jdbcTemplate.update(sql);
        System.out.println(delete);
        return delete == 1;
    }

    @Override
    public List<T> getAll() {
        return jdbcTemplate.query(sqlSelectEntity(clazz), new BeanPropertyRowMapper<>(clazz));

    }

//    @Override
//    public List<T> getAll() {
//        List<T> listT=new ArrayList<>();
//        List<Map<String, Object>> listMap = jdbcTemplate.queryForList(sqlSelectEntity(clazz));
//        for (Map<String, Object> map : listMap) {
//            T entity = getBean(map, clazz);
//            listT.add(entity);
//        }
//        System.out.println();
//       return listT;
//    }

}
