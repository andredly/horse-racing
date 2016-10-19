package com.charniauski.training.horsesrace.daodb;

import com.charniauski.training.horsesrace.datamodel.SecurityLevel;

import java.util.List;

/**
 * Created by Andre on 19.10.2016.
 */
public interface SecurityLevelDao {

    SecurityLevel get(Long id);

    void insert(SecurityLevel entity);

    void update(SecurityLevel entity);

    void delete(Long id);

    List<SecurityLevel> getAll();
}
