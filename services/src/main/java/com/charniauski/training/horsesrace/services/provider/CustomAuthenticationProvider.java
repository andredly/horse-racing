package com.charniauski.training.horsesrace.services.provider;

import com.charniauski.training.horsesrace.datamodel.Account;
import com.charniauski.training.horsesrace.services.AccountService;
import com.charniauski.training.horsesrace.services.authcaching.AuthenticationMemcachedService;
import com.charniauski.training.horsesrace.services.localthread.SecurityContextHolder;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.Collection;

@Service
public class CustomAuthenticationProvider implements AuthenticationProvider {

//    @Inject
    AuthenticationMemcachedService authenticationCachingService;

    @Inject
    private AccountService accountService;

    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) authentication;
        String username = String.valueOf(auth.getPrincipal());
        if (username.equals("")) {
            return null;
        }
        String password = String.valueOf(auth.getCredentials());
        if (username.equals("")) {
            return null;
        }
        if (authenticationCachingService != null) {
            UsernamePasswordAuthenticationToken token = authenticationCachingService.get(username + password);
            if (token != null) {
                addLocalThread(username, password, token.getAuthorities());
                return token;
            }
        }
        Account account = accountService.getByLogin(username);
        if (account == null) {
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
            return token;
        }
        if (account.getLogin().equals(username) && account.getPassword().equals(password)) {
            GrantedAuthority authority = new SimpleGrantedAuthority(account.getStatus().name());
            addLocalThread(username, password, Arrays.asList(authority));
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password, Arrays.asList(authority));
            if (authenticationCachingService != null) {
                authenticationCachingService.put(username + password, token);
            }
            return token;
        } else {
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
            return token;
        }
    }


    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    private void addLocalThread(String username, String password, Collection<GrantedAuthority> authority) {
        UserDetails userDetails = new User(username, password, authority);
        SecurityContextHolder.setLoggedUserDetails(userDetails);
    }
}