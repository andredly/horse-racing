package com.charniauski.training.horsesrace.daodb.cache;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.google.inject.BindingAnnotation;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKeyGenerator;


@Retention(RUNTIME)
@BindingAnnotation
@Target(ElementType.METHOD)
public @interface Cached {
    int timeToLiveSeconds() default 0;

    Class<? extends KeyGenerator> keyGeneratorClass() default SimpleKeyGenerator.class;
}