package com.charniauski.training.horsesrace.daodb.impl;

import com.charniauski.training.horsesrace.daodb.SecurityLevelDao;
import com.charniauski.training.horsesrace.datamodel.SecurityLevel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Andre on 19.10.2016.
 */
@Repository
public class SecurityLevelDaoImpl implements SecurityLevelDao {
    @Override
    public SecurityLevel get(Long id) {
        // TODO: 19.10.2016
        return null;
    }

    @Override
    public void insert(SecurityLevel entity) {
        // TODO: 19.10.2016
    }

    @Override
    public void update(SecurityLevel entity) {
        // TODO: 19.10.2016
    }

    @Override
    public void delete(Long id) {
        // TODO: 19.10.2016
    }

    @Override
    public List<SecurityLevel> getAll() {
        // TODO: 19.10.2016
        return null;
    }
}
