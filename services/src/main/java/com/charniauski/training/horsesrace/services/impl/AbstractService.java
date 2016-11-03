package com.charniauski.training.horsesrace.services.impl;

import com.charniauski.training.horsesrace.datamodel.AbstractModel;
import com.charniauski.training.horsesrace.services.GenericService;
import com.charniauski.training.horsesrace.services.exception.NoSuchEntityException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ivc4 on 24.10.2016.
 */
@Service
public abstract class AbstractService<T extends AbstractModel, PK> implements GenericService<T, PK> {


    @Transactional
    @Override
    public List<PK> saveAll(List<T> listEntity)throws NoSuchEntityException{
        ArrayList<PK> arrayList=new ArrayList<>();
        for (T entity : listEntity) {
            arrayList.add(save(entity));
        }
        return arrayList;
    }

    @Override
    public PK save(T entity) throws NoSuchEntityException {
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
