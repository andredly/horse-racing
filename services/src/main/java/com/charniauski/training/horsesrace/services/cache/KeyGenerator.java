package com.charniauski.training.horsesrace.services.cache;


import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Created by ivc4 on 11.11.2016.
 */
public interface KeyGenerator {
    Object generate(ProceedingJoinPoint joinPoint);
}
