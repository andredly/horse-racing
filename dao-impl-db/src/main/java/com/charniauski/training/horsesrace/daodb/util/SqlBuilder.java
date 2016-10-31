package com.charniauski.training.horsesrace.daodb.util;

import com.charniauski.training.horsesrace.datamodel.AbstractModel;
import com.charniauski.training.horsesrace.datamodel.Column;
import com.charniauski.training.horsesrace.datamodel.Entity;

import java.lang.reflect.Field;
import java.util.List;

import static com.charniauski.training.horsesrace.daodb.util.ReflectionUtil.getFields;
import static com.charniauski.training.horsesrace.daodb.util.ReflectionUtil.getTableName;

/**
 * Created by Andre on 22.10.2016.
 */

public class SqlBuilder {

    public static <T extends AbstractModel> String sqlInsertOrUpdateEntity(T entity, boolean isInsert) {
        Class<?> clazz = entity.getClass();
        Entity entityAnnotation = clazz.getAnnotation(Entity.class);
        StringBuilder columnSb = new StringBuilder();
        StringBuilder valueSb = new StringBuilder();
        if (isInsert) {
            valueSb.append("VALUES (");
            columnSb.append("INSERT INTO ").append(entityAnnotation.tableName()).append(" (");
        } else {
            valueSb.append("= (");
            columnSb.append("UPDATE ").append(entityAnnotation.tableName()).append(" SET(");
        }
        List<Field> allFields = getFields(clazz);
        Field fieldId = null;
        try {
            for (Field field : allFields) {
                if (field.getName().equals("id")) fieldId = field;

                field.setAccessible(true);
                Column column = field.getAnnotation(Column.class);
                if (isInsert&&entityAnnotation.autoincrementColumn().equals(field.getName())) {
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
            valueSb.deleteCharAt(valueSb.lastIndexOf(",")).deleteCharAt(valueSb.lastIndexOf(" "))

                    .append("); ");
            columnSb.deleteCharAt(columnSb.lastIndexOf(",")).deleteCharAt(columnSb.lastIndexOf(" "))
                    .append(") ")
                    .append(valueSb.toString());
        } else {
            try {
                valueSb.deleteCharAt(valueSb.lastIndexOf(",")).deleteCharAt(valueSb.lastIndexOf(" "))
                        .append(") WHERE id=")
                        .append(fieldId.get(entity))
                        .append(";");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            columnSb.deleteCharAt(columnSb.lastIndexOf(",")).deleteCharAt(columnSb.lastIndexOf(" "))
                    .append(") ")
                    .append(valueSb.toString());
        }
        //        String sql = valueSb.toString();
        return columnSb.toString();
    }



    public static <T extends AbstractModel> String sqlSelectEntity(Class<T> clazz) {
        return "SELECT * FROM " + getTableName(clazz) + " ";
    }

    public static <T extends AbstractModel> String sqlDeleteEntity(Class<T> clazz) {
        return "DELETE FROM " + getTableName(clazz) + " WHERE id =";
    }
}
