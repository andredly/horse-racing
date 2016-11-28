package com.charniauski.training.horsesrace.web.security;

import com.charniauski.training.horsesrace.services.impl.AuthenticationServiceCustom;
import com.charniauski.training.horsesrace.web.BasicAuthFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.inject.Inject;

@Configuration
@ComponentScan("com.charniauski.training.horsesrace.web.security")
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Inject
    AuthenticationServiceCustom authenticationService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().antMatchers("/**").hasAnyRole("ADMIN", "CLIENT").
//                and().formLogin();
//        http.authorizeRequests()
//                .antMatchers("/securityNone").hasAnyRole("ADMIN", "CLIENT")
//                .anyRequest().authenticated()
//                .and()
//                .httpBasic()
//                .authenticationEntryPoint(authenticationEntryPoint);
//

//        http
//                .exceptionHandling()
//                .authenticationEntryPoint(entryPoint())
//                .and()
//                .authorizeUrls()
//                .anyRequest().authenticated()
//                .and()
//                .httpBasic();
        http
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic();
//        http.addFilterAfter(new BasicAuthFilter(),
//                BasicAuthenticationFilter.class);
    }


    @Bean
    public BasicAuthenticationEntryPoint entryPoint() {
        BasicAuthenticationEntryPoint basicAuthEntryPoint = new BasicAuthenticationEntryPoint();
        basicAuthEntryPoint.setRealmName("My Realm");
        return basicAuthEntryPoint;
    }

    @Inject
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        ShaPasswordEncoder encoder = new ShaPasswordEncoder();
        auth.userDetailsService(authenticationService).passwordEncoder(encoder);
    }

}   