package com.charniauski.training.horsesrace.daodb.impl;

import com.charniauski.training.horsesrace.daodb.GenericDao;
import com.charniauski.training.horsesrace.daodb.util.ReflectionUtil;
import com.charniauski.training.horsesrace.daodb.util.SqlUtil;
import com.charniauski.training.horsesrace.datamodel.AbstractModel;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.util.ReflectionUtils;

import javax.inject.Inject;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

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
        sql = sql + "WHERE id =?;";
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
        sql = sql + " id=" + entity.getId();
        System.out.println(sql);
        jdbcTemplate.update(sql);
    }

    //    @SuppressWarnings("unchecked")
    @Override
    public boolean delete(PK id) {
        String sql = sqlUtil.sqlDeleteEntity(clazz);
        sql = sql + " id=" + id;
        System.out.println(sql);
        int delete = jdbcTemplate.update(sql);
        System.out.println(delete);
        return delete == 1;
    }

    @Override
    public List<T> getAll()  {
        Object[] beanValue = new Object[0];
        try {
            beanValue = ReflectionUtil.getBeanValue(clazz.newInstance()).toArray();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(Arrays.toString(beanValue));
//        List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT * FROM client;");
        List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT * FROM client;",beanValue);
        for (Map<String, Object> map : list) {

            T entity= null;
            try {
                entity = clazz.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            BeanUtilsBean instance = BeanUtilsBean.getInstance();
            try {
                instance.populate(entity,map);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
//            System.out.println(map);
//            System.out.println(entity);

        }

        if (true) throw new UnsupportedOperationException();
        //// TODO: SORT!!! (Column)
        return new ArrayList<T>();

    }

//    public T select(T entity){
//        KeyHolder keyHolder = new GeneratedKeyHolder();
//        Object o = jdbcTemplate.queryForList("", new Object[]{}, new int[]{}, Object.class);
//        int update = jdbcTemplate.update("", new BeanPropertySqlParameterSource(
//                entity), keyHolder);
//        return null;
//    }


    public int update(String sql, Object... args) {
        return jdbcTemplate.update(sql, args);
    }

    public Map<String, Object> queryForMap(String sql, Object... args) {
        return jdbcTemplate.queryForMap(sql, args);
    }

    public List<Map<String, Object>> queryForList(String sql, Object... args) {
        return jdbcTemplate.queryForList(sql, args);
    }
}
