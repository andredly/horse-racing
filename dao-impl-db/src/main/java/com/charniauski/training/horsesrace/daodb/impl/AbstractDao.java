package com.charniauski.training.horsesrace.daodb.impl;

import com.charniauski.training.horsesrace.daodb.GenericDao;
import com.charniauski.training.horsesrace.daodb.util.SqlUtil;
import com.charniauski.training.horsesrace.datamodel.AbstractModel;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by ivc4 on 21.10.2016.
 */
@Repository
public abstract class AbstractDao<T extends AbstractModel, PK> implements GenericDao<T, PK> {

    @Inject
    private JdbcTemplate jdbcTemplate;

    @Inject
    private SqlUtil sqlUtil;

    private Class<T> clazz;

    protected AbstractDao(Class<T> clazz) {
        this.clazz = clazz;
    }

//    @SuppressWarnings("unchecked")
    @Override
    public T get(PK id) {
        String sql = sqlUtil.sqlSelectEntity(clazz);
        sql=sql+ "WHERE id =?;";
        System.out.println(sql);
        return jdbcTemplate.queryForObject(
                sql,
                new Object[]{id}, new BeanPropertyRowMapper<>(clazz));
//        List<T> list = jdbcTemplate.queryForList(sql, clazz);
//        if (list.isEmpty())return null;
//        System.out.println(list);
//        return list.get(0);
    }
//    @SuppressWarnings("unchecked")
    @Override
    public PK insert(T entity) {
        String sql = sqlUtil.sqlInsertAndUpdateEntity(entity, true);
        System.out.println(sql);
        KeyHolder generatedKeyHolder = new GeneratedKeyHolder();
//        jdbcTemplate.update("",new Object[]{},new int[]{})
        jdbcTemplate.update(con -> con.prepareStatement(sql, new String[]{"id"}), generatedKeyHolder);
        Object id = generatedKeyHolder.getKey().longValue();
        return (PK) id;
    }
//    @SuppressWarnings("unchecked")
    @Override
    public void update(T entity) {
        String sql = sqlUtil.sqlInsertAndUpdateEntity(entity, false);
        sql=sql+ " id=" + entity.getId();
        System.out.println(sql);
        jdbcTemplate.update(sql);
    }
//    @SuppressWarnings("unchecked")
    @Override
    public boolean delete(PK id) {
        String sql= sqlUtil.sqlDeleteEntity(clazz);
        sql=sql + " id=" + id;
        System.out.println(sql);
        int delete = jdbcTemplate.update(sql);
        System.out.println(delete);
        return delete == 1;
    }

    @Override
    public List<T> getAll() {
        List<Map<String, Object>> list=jdbcTemplate.queryForList("SELECT * FROM client;");
        for (Map<String,Object> map:list){
            System.out.println(map);
        }

        //// TODO: SORT!!! (Column)
        return new ArrayList<T>();
    }

    public T select(T entity){
        KeyHolder keyHolder = new GeneratedKeyHolder();
        Object o = jdbcTemplate.queryForList("", new Object[]{}, new int[]{}, Object.class);
        int update = jdbcTemplate.update("", new BeanPropertySqlParameterSource(
                entity), keyHolder);
        return null;
    }


}
