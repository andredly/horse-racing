//package com.charniauski.training.horsesrace.web.security;
//
//import com.charniauski.training.horsesrace.web.security.SecurityContextHolder;
//import com.charniauski.training.horsesrace.web.controller.RacecourseController;
//import com.charniauski.training.horsesrace.web.security.Security;
//import org.aopalliance.aop.Advice;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.context.annotation.EnableAspectJAutoProxy;
//import org.springframework.core.annotation.Order;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.List;
////@Component
////@Aspect
////@EnableAspectJAutoProxy
//public class SecurityAspect implements Advice {
//
//    @Pointcut(value = "execution(* com.charniauski.training.horsesrace.services.*.get*(..))")
//    public void anyGetMethod() {
//    }
//
////    @Pointcut(value = "execution(* com.charniauski.training.horsesrace.web.controller.*.*(..))")
////    public void anyGetMethod() {
////    }
//
//    @Pointcut(value = "@annotation(security)", argNames = "security")
//    protected void annotatedSecurityMethods(Security security) {
//    }
//
//    @Pointcut(value = "@annotation(requestMapping)", argNames = "requestMapping")
//    protected void annotatedRequestMapping(RequestMapping requestMapping) {
//    }
//
//    @Around(value = "anyGetMethod()||annotatedSecurityMethods(security)", argNames = "joinPoint,security")
//    public Object around(ProceedingJoinPoint joinPoint, Security security) throws Throwable {
//        List<String> listRole = Arrays.asList(security.role());
//        System.out.println(listRole);
//        if (listRole.isEmpty()) {
//            return joinPoint.proceed();
//        }
//        UserDetails loggedUser = SecurityContextHolder.getLoggedUserDetails();
//        System.out.println(loggedUser);
//        Collection<GrantedAuthority> authorities = loggedUser.getAuthorities();
//        boolean contains = listRole.containsAll(authorities);
//        if (!contains) {
//            return new ResponseEntity<>(HttpStatus.NON_AUTHORITATIVE_INFORMATION);
//        }
//        System.out.println(contains);
//        Object result = joinPoint.proceed();
//        return result;
//    }
//
//    @Before("anyGetMethod()")
//    public void beforeFoo(JoinPoint joinPoint) {
//        System.out.println("foooo");
//    }
//}