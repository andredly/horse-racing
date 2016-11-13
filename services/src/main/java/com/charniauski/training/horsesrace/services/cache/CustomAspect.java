package com.charniauski.training.horsesrace.services.cache;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

//@Service
@Aspect
public class CustomAspect {

    @Inject
//    private CacheAdapterEhcache cache;
    private CacheAdapterSimpleCache cache;



    @Around(value = "@annotation(Cached)&& execution(* com.charniauski.training.horsesrace.services.*.get*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        CacheKeyGenerator keyGenerator = new CacheKeyGenerator();
        String key = keyGenerator.generate(joinPoint);
        System.out.println("key " + key);
        if (cache.get(key)!=null){
            System.out.println(cache);
            return cache.get(key);
        }
        Object result = joinPoint.proceed();
        cache.put(key,result);
        System.out.println("result ");
        return result;
    }

}