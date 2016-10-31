package com.charniauski.training.horsesrace.services;

import com.charniauski.training.horsesrace.daodb.GenericDao;
import com.charniauski.training.horsesrace.datamodel.Client;
import com.charniauski.training.horsesrace.services.exception.NoSuchEntityException;

import java.util.List;

/**
 * Created by ivc4 on 24.10.2016.
 */
public interface GenericService<T,PK> {

    GenericDao getGenericDao();

    List<T> getAll();

    void saveAll(List<T> clients) throws NoSuchEntityException;

    PK save(T entity);

    boolean delete(T client);

    T get(PK id);
}
