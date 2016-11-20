package com.charniauski.training.horsesrace.services.cache;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target(ElementType.METHOD)
public @interface Cached {
    int timeToLiveSeconds() default 0;
    Class<? extends KeyGenerator> keyGeneratorClass() default CacheKeyGenerator.class;
}