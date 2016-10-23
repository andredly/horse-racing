package com.charniauski.training.horsesrace.daodb;

import com.charniauski.training.horsesrace.datamodel.AbstractModel;

import java.util.List;

/**
 * Created by Andre on 19.10.2016.
 */
public interface GenericDao<T, PK> {

    T get(PK id);

    PK insert(T entity);

    void update(T entity);

    boolean delete(PK id);;

    List<T> getAll();;

}
