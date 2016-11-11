package com.charniauski.training.horsesrace.services.cache;


import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Arrays;

/**
 * Created by ivc4 on 11.11.2016.
 */
public class CacheKeyGenerator implements KeyGenerator{

    @Override
    public String generate(ProceedingJoinPoint joinPoint) {
        String nameClass = joinPoint.getSignature().getDeclaringTypeName();
        String method=joinPoint.getSignature().toLongString();
        StringBuilder stringBuilder=new StringBuilder(nameClass).append(method);
        Object[] args = joinPoint.getArgs();
        if (args.length==0) {
            return stringBuilder.toString();
        }
        stringBuilder.append("(").append(args[0]);
        for (int i = 1; i < args.length; i++) {
            stringBuilder.append(", ").append(args[i].toString());
        }
        return stringBuilder.append(")").toString();
    }
}
