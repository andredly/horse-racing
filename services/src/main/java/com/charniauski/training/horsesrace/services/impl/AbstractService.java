package com.charniauski.training.horsesrace.services.impl;

import com.charniauski.training.horsesrace.daodb.GenericDao;
import com.charniauski.training.horsesrace.datamodel.AbstractModel;
import com.charniauski.training.horsesrace.services.GenericService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ivc4 on 24.10.2016.
 */
@Service
public abstract class AbstractService<T extends AbstractModel, PK> implements GenericService<T, PK> {

    private GenericDao genericDao;

    private Class<T> clazz;

    protected AbstractService(Class<T> clazz)
    {
        this.clazz = clazz;
    }

    @Override
    public void saveAll(List<T> clients) {

    }

    @Override
    public PK insert(T entity) {
        if (entity == null) throw new IllegalArgumentException();
        genericDao=getGenericDao();
        return (PK) genericDao.insert(entity);

    }

    @Override
    public void update(T entity) {
        if (entity == null) throw new IllegalArgumentException();
        genericDao=getGenericDao();
        genericDao.update(entity);
    }


    @Override
    public boolean delete(T client) {
        genericDao=getGenericDao();
        return client != null && genericDao.delete(client.getId());
    }

    @Override
    public T get(PK id) {
        genericDao=getGenericDao();
        return (T) genericDao.get(id);
    }

    @Override
    public List<T> getAll() {
        genericDao=getGenericDao();
        return genericDao.getAll();
    }
}
