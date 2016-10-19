package com.charniauski.training.horsesrace.services;

import com.charniauski.training.horsesrace.datamodel.User;

import java.util.List;

/**
 * Created by Andre on 18.10.2016.
 */
public interface UserService {

    void saveAll(List<User> users);

    void save(User user);

    boolean isDaoExist();
}
