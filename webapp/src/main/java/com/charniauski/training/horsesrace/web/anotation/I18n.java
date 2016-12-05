package com.charniauski.training.horsesrace.web.anotation;

/**
 * Created by Andre on 22.10.2016.
 */
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface I18n {

    Language language() default Language.RU;
}
