package com.charniauski.training.horsesrace.daodb;

import com.charniauski.training.horsesrace.datamodel.User;

import java.util.List;

/**
 * Created by Andre on 19.10.2016.
 */
public interface UserDao {

    User get(Long id);

    void insert(User entity);

    void update(User entity);

    void delete(Long id);

    List<User> getAll();
}
