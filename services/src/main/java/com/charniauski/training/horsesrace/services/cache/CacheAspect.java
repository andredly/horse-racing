package com.charniauski.training.horsesrace.services.cache;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import javax.inject.Inject;

//@Service
@Aspect
public class CacheAspect {

    @Inject
    private Cacheable cache;
//    private SimpleCache cache;
//    private CacheAdapterEhcache cache;

    @Pointcut(value = "execution(* com.charniauski.training.horsesrace.services.*.get*(..))")
    public void anyGetMethod() {
    }

    @Pointcut(value = "@annotation(cached)", argNames = "cached")
    protected void annotatedCachedMethods(Cached cached) {
    }

    @Around(value = "anyGetMethod()&&annotatedCachedMethods(cached)", argNames = "joinPoint,cached")
    public Object around(ProceedingJoinPoint joinPoint, Cached cached) throws Throwable {
        KeyGenerator keyGenerator = cached.keyGeneratorClass().newInstance();
        String key = keyGenerator.generate(joinPoint);
        if (cache.isKeyInCache(key)) {
            Object o = cache.get(key);
            if (o != null) return o;
        }
        Object result = joinPoint.proceed();
        if (result == null) {
            return null;
        }
        cache.put(key, result, cached.timeToLiveSeconds());
        return result;
    }
}