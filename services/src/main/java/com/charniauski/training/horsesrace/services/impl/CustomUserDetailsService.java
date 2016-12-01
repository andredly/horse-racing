package com.charniauski.training.horsesrace.services.impl;

import com.charniauski.training.horsesrace.datamodel.Account;
import com.charniauski.training.horsesrace.services.AccountService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Arrays;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Inject
    private AccountService accountService;

    public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException {
        Account account = accountService.getByLogin(username);
        GrantedAuthority authority = new SimpleGrantedAuthority(account.getStatus().name());
        UserDetails userDetails = (UserDetails)new User(account.getLogin(),
                account.getPassword(), Arrays.asList(authority));
        return userDetails;
    }

}
