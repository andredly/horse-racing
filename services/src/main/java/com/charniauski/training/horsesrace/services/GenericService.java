package com.charniauski.training.horsesrace.services;

import com.charniauski.training.horsesrace.daodb.GenericDao;
import com.charniauski.training.horsesrace.datamodel.Client;

import java.util.List;

/**
 * Created by ivc4 on 24.10.2016.
 */
public interface GenericService<T,PK> {

    GenericDao getGenericDao();

    List<T> getAll();

    void saveAll(List<T> clients);

    PK insert(T client);

    void update(T client);

    boolean delete(T client);

    T get(PK id);
}