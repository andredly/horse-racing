package com.charniauski.training.horsesrace.daodb.impl;

import com.charniauski.training.horsesrace.daodb.GenericDao;
import com.charniauski.training.horsesrace.daodb.util.SqlCreate;
import com.charniauski.training.horsesrace.datamodel.AbstractModel;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by ivc4 on 21.10.2016.
 */
@Repository
public abstract class AbstractDao<T extends AbstractModel, PK> implements GenericDao<T, PK> {

    @Inject
    private JdbcTemplate jdbcTemplate;

    @Inject
    private SqlCreate sqlCreate;

    private Class<T> clazz;

    protected AbstractDao(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public T get(PK id) {
        String sql = sqlCreate.sqlSelectEntity(clazz);
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

    @Override
    public PK insert(T entity) {
        String sql = sqlCreate.sqlInsertEntity(entity, true);
        System.out.println(sql);
        KeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> con.prepareStatement(sql, new String[]{"id"}), generatedKeyHolder);
        Object id = generatedKeyHolder.getKey().longValue();

        return (PK) id;
    }

    @Override
    public void update(T entity) {
        String sql = sqlCreate.sqlInsertEntity(entity, false);
        sql=sql+ " id=" + entity.getId();
        System.out.println(sql);
        jdbcTemplate.update(sql);
    }

    @Override
    public boolean delete(PK id) {
        String sql= sqlCreate.sqlDeleteEntity(clazz);
        sql=sql + " id=" + id;
        System.out.println(sql);
        int delete = jdbcTemplate.update(sql);

        System.out.println(delete);
        return delete == 1;
    }

    @Override
    public List<T> getAll() {
        //// TODO: 24.10.2016
        return null;
    }


}
