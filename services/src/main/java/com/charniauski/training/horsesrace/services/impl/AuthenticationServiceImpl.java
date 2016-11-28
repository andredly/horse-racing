package com.charniauski.training.horsesrace.services.impl;

import com.charniauski.training.horsesrace.services.AuthenticationService;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Override
    public boolean validateUserPassword(String username,
            String password) {
        // TODO DAO query
        return username.equals("login")
                && password.equals("pass");
    }

}
