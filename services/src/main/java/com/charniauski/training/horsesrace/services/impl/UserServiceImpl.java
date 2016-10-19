package com.charniauski.training.horsesrace.services.impl;

import com.charniauski.training.horsesrace.daodb.UserDao;
import com.charniauski.training.horsesrace.datamodel.User;
import com.charniauski.training.horsesrace.services.UserService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Andre on 19.10.2016.
 */
@Service
public class UserServiceImpl implements UserService {

    public UserServiceImpl() {
    }

    @Inject
    private UserDao userDao;

    @Override
    public void saveAll(List<User> users) {

    }

    @Override
    public void save(User user) {
        if (user.getId() == null) {
            userDao.insert(user);
        } else {
            userDao.update(user);
        }
    }

    @Override
    public boolean isDaoExist() {
        return userDao != null;
    }
}
