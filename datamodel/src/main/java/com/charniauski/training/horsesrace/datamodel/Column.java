package com.charniauski.training.horsesrace.datamodel;

/**
 * Created by Andre on 22.10.2016.
 */
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
    String columnName() default "";
    enum DataType {
        BIGINT, DOUBLE, VARCHAR, TIMESTAMP
    };
    DataType dataType() default DataType.BIGINT;
    boolean isAutoIncrement() default false;
}
