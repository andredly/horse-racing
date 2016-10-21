package com.charniauski.training.horsesrace.daodb;

import com.charniauski.training.horsesrace.datamodel.User;

import java.util.List;

/**
 * Created by Andre on 19.10.2016.
 */
public interface UserDao extends GenericDao<User, Long>{

    List<User> getAll();
}
