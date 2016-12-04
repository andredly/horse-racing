package com.charniauski.training.horsesrace.services.cacherequest;


import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Created by ivc4 on 11.11.2016.
 */
public interface KeyGenerator {
    String generate(ProceedingJoinPoint joinPoint);
}
