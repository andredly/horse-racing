package com.charniauski.training.horsesrace.services.impl;

import com.charniauski.training.horsesrace.daodb.GenericDao;
import com.charniauski.training.horsesrace.daodb.util.ReflectionUtil;
import com.charniauski.training.horsesrace.datamodel.AbstractModel;
import com.charniauski.training.horsesrace.datamodel.Entity;
import com.charniauski.training.horsesrace.services.GenericService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by ivc4 on 24.10.2016.
 */
@Service
public abstract class AbstractService<T extends AbstractModel, PK> implements GenericService<T, PK> {

    @Override
    public void saveAll(List<T> listEntity) {
        for (T entity : listEntity) {
            save(entity);
        }
    }

    @Override
    public PK save(T entity) {
        if (entity.getId() == null) return (PK) getGenericDao().insert(entity);
        else {
            getGenericDao().update(entity);
            return (PK) entity.getId();
        }
    }


    @Override
    public boolean delete(T entity) {
        return getGenericDao().delete(entity.getId());
    }

    @Override
    public T get(PK id) {
        return (T) getGenericDao().get(id);
    }

    @Override
    public List<T> getAll() {
        return getGenericDao().getAll();
    }
}
