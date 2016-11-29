package com.charniauski.training.horsesrace.services.impl;

import com.charniauski.training.horsesrace.services.CustomAuthenticationService;
import org.springframework.stereotype.Service;

@Service
public class CustomAuthenticationServiceImpl implements CustomAuthenticationService {

    @Override
    public boolean validateUserPassword(String username,
                                        String password) {
        // TODO DAO query
        return username.equals("login")
                && password.equals("pass");
    }

}
