//package com.charniauski.training.horsesrace.web.security;
//
//import com.charniauski.training.horsesrace.services.impl.CustomUserDetailsService;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.ImportResource;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
//
//import javax.inject.Inject;
//
//@Configuration
//@ComponentScan("com.charniauski.training.horsesrace.web.security.*, com.charniauski.training.horsesrace.web.controller.*" +
//        "com.charniauski.training.horsesrace.web.converter.*")
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Inject
//    private CustomUserDetailsService customUserDetailsService;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
////                http.authorizeRequests().anyRequest().fullyAuthenticated().and().
////                httpBasic().and().
////                csrf().disable();
//        http.authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .and()
//                .httpBasic();
//    }
//
//
//    @Bean
//    public BasicAuthenticationEntryPoint entryPoint() {
//        BasicAuthenticationEntryPoint basicAuthEntryPoint = new BasicAuthenticationEntryPoint();
//        basicAuthEntryPoint.setRealmName("My Realm");
//        return basicAuthEntryPoint;
//    }
//
//    @Inject
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
////        ShaPasswordEncoder encoder = new ShaPasswordEncoder();
////        auth.userDetailsService(authenticationService).passwordEncoder(encoder);
//        auth.userDetailsService(customUserDetailsService);
//    }
//
//}