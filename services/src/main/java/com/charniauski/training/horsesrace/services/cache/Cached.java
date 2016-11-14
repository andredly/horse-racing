package com.charniauski.training.horsesrace.services.cache;

import com.google.inject.BindingAnnotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Retention(RUNTIME)
@BindingAnnotation
@Target(ElementType.METHOD)
public @interface Cached {
}