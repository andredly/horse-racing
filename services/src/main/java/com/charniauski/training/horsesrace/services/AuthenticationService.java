package com.charniauski.training.horsesrace.services;

import com.charniauski.training.horsesrace.datamodel.Account;

public interface AuthenticationService {

    boolean validateUserPassword(String username, String password);

}
