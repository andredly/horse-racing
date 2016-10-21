package com.charniauski.training.horsesrace.daodb;

import java.util.List;

/**
 * Created by Andre on 19.10.2016.
 */
public interface GenericDao<T, PK> {

    T get(PK id);

    void insert(T entity);

    void update(T entity);

    void delete(PK id);;

    List<T> getAll();;

}
