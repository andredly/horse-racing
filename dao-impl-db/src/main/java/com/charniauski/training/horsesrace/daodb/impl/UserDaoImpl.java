package com.charniauski.training.horsesrace.daodb.impl;

import com.charniauski.training.horsesrace.daodb.UserDao;
import com.charniauski.training.horsesrace.datamodel.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Andre on 19.10.2016.
 */
@Repository
public class UserDaoImpl implements UserDao {
    public UserDaoImpl() {
    }

    @Override
    public User get(Long id) {
        // TODO: 19.10.2016
        return null;
    }

    @Override
    public void insert(User entity) {
        // TODO: 19.10.2016
    }

    @Override
    public void update(User entity) {
        // TODO: 19.10.2016
    }

    @Override
    public void delete(Long id) {
        // TODO: 19.10.2016
    }

    @Override
    public List<User> getAll() {
        // TODO: 19.10.2016
        return null;
    }
}
