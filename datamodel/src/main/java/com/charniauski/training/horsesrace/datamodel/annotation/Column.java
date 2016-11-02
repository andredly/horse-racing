package com.charniauski.training.horsesrace.datamodel.annotation;

/**
 * Created by Andre on 22.10.2016.
 */
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.sql.Types;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
    String columnName() default "";
    enum DataType {
        BIGINT(Types.BIGINT), DOUBLE_PRECISION(Types.DOUBLE), VARCHAR(Types.VARCHAR),
        TIMESTAMP_WITH_TIME_ZONE(Types.TIMESTAMP_WITH_TIMEZONE), INTEGER(Types.INTEGER), DATE(Types.DATE);
        private int typeSQL;
        DataType(int typeSQL) {
            this.typeSQL=typeSQL;
        }
        public int getTypeSQL() {
            return typeSQL;
        }
    }
    DataType dataType() default DataType.BIGINT;
    boolean isAutoIncrement() default false;
}
