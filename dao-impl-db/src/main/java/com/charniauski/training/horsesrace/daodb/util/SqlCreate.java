package com.charniauski.training.horsesrace.daodb.util;

import com.charniauski.training.horsesrace.datamodel.AbstractModel;
import com.charniauski.training.horsesrace.datamodel.Column;
import com.charniauski.training.horsesrace.datamodel.Entity;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Field;

/**
 * Created by Andre on 22.10.2016.
 */
@Repository
public class SqlCreate<T extends AbstractModel, PK> {

    public String sqlInsertEntity(T entity, boolean isInsert) {
        Class<?> clazz = entity.getClass();
        Entity entityAnnotation = (Entity) clazz.getAnnotation(Entity.class);
        StringBuffer columnSb = new StringBuffer();
        StringBuffer valueSb = new StringBuffer();
        if (isInsert) {
            valueSb.append("VALUES (");
            columnSb.append("INSERT INTO ").append(entityAnnotation.tableName()).append(" (");
        } else {
            valueSb.append("= (");
            columnSb.append("UPDATE ").append(entityAnnotation.tableName()).append(" SET(");
        }
        Field[] fieldsEntity = clazz.getDeclaredFields();
        Class<?> superclass = clazz.getSuperclass();
        Field[] fieldsSuperclassEntity = superclass.getDeclaredFields();
        Field[] allFields = ArrayUtils.addAll(fieldsSuperclassEntity, fieldsEntity);
        try {
            for (Field field : allFields) {
                field.setAccessible(true);
                Column column = field.getAnnotation(Column.class);
                if (isInsert && column.isAutoIncrement()) {
                    continue;
                }
                if (field.getType().getSimpleName().endsWith("String") || field.getType().getSimpleName().endsWith("Date")) {
                    if (null == field.get(entity)) {
                        continue;
                    } else {
                        valueSb.append("'").append(field.get(entity)).append("', ");
                    }
                } else {
                    valueSb.append(field.get(entity)).append(", ");
                }
                columnSb.append(column.columnName()).append(", ");
            }
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
        if (isInsert) {
            valueSb.deleteCharAt(valueSb.lastIndexOf(",")).deleteCharAt(valueSb.lastIndexOf(" ")).append("); ");
            columnSb.deleteCharAt(columnSb.lastIndexOf(",")).deleteCharAt(columnSb.lastIndexOf(" ")).append(") ").append(valueSb.toString());
        } else {
            valueSb.deleteCharAt(valueSb.lastIndexOf(",")).deleteCharAt(valueSb.lastIndexOf(" ")).append(") WHERE ");
            columnSb.deleteCharAt(columnSb.lastIndexOf(",")).deleteCharAt(columnSb.lastIndexOf(" ")).append(") ").append(valueSb.toString());
        }
        String sql = columnSb.toString();
//        String sql = valueSb.toString();
        return sql;
    }

    public String sqlSelectEntity(Class<T> clazz) {
        Entity entityAnnotation = (Entity) clazz.getAnnotation(Entity.class);
        StringBuffer columnSb = new StringBuffer();
        StringBuffer valueSb = new StringBuffer();
        columnSb.append("SELECT * FROM ").append(entityAnnotation.tableName()).append(" ");

//        columnSb.deleteCharAt(columnSb.lastIndexOf(",")).deleteCharAt(columnSb.lastIndexOf(" ")).append(") ").append(valueSb.toString());
//        System.out.println(valueSb.toString());
        String sql = columnSb.toString();
        return sql;
    }

    public String sqlDeleteEntity(Class<T> clazz) {
        Entity entityAnnotation = (Entity) clazz.getAnnotation(Entity.class);
        StringBuffer columnSb = new StringBuffer();
        StringBuffer valueSb = new StringBuffer();
        columnSb.append("DELETE FROM ").append(entityAnnotation.tableName()).append(" WHERE ");

//        columnSb.deleteCharAt(columnSb.lastIndexOf(",")).deleteCharAt(columnSb.lastIndexOf(" ")).append(") ").append(valueSb.toString());
//        System.out.println(valueSb.toString());
        String sql = columnSb.toString();
        return sql;
    }



}
