package com.charniauski.training.horsesrace.services;


import com.charniauski.training.horsesrace.daoapi.GenericDao;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ivc4 on 24.10.2016.
 */
public interface GenericService<T,PK> {

    GenericDao<T,PK> getGenericDao();

    List<T> getAll();

    @Transactional
    List<PK> saveAll(List<T> entity) ;

    @Transactional
    PK save(T entity) ;

    @Transactional
    boolean delete(PK id);

    T get(PK id);
}
