package com.charniauski.training.horsesrace.services.impl;

import com.charniauski.training.horsesrace.datamodel.Account;
import com.charniauski.training.horsesrace.services.AccountService;
import com.charniauski.training.horsesrace.services.CustomAuthenticationService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Arrays;

@Service
public class CustomAuthenticationServiceImpl implements CustomAuthenticationService {

    @Inject
    private AccountService accountService;

    @Override
    public boolean validateUserPassword(String username, String password) {
        Account account = accountService.getByLogin(username);
        if (account == null || !account.getPassword().equals(password)) {
            return false;
        }
        GrantedAuthority authority = new SimpleGrantedAuthority(account.getStatus().name());
        User user = new User(account.getLogin(),
                account.getPassword(), Arrays.asList(authority));
        return true;
    }

}
