package com.charniauski.training.horsesrace.daodb;

import java.util.List;

/**
 * Created by Andre on 19.10.2016.
 */
public interface GenericDao<T, E extends Exception> {

    T get(Long id) throws E;

    void save(T entity) throws E;;

    void delete(Long id) throws E;;

    List<T> getAll() throws E;;

}
