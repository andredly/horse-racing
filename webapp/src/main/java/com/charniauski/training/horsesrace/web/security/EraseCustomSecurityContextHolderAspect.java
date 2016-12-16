package com.charniauski.training.horsesrace.web.security;


import org.aopalliance.aop.Advice;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class EraseCustomSecurityContextHolderAspect implements Advice {
    

    @Pointcut(value = "@annotation(org.springframework.security.access.prepost.PreAuthorize)")
    void annotatedPreAuthorizeMethods() {
    }

    @After("annotatedPreAuthorizeMethods()")
    public void beforeControllerMappingMethods(JoinPoint joinPoint) {

        CustomSecurityContextHolder.removeLoggedUserDetails();
    }
}