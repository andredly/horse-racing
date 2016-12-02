package com.charniauski.training.horsesrace.daodb.util;

import com.charniauski.training.horsesrace.datamodel.AbstractModel;
import com.charniauski.training.horsesrace.datamodel.annotation.Column;
import com.charniauski.training.horsesrace.datamodel.annotation.Entity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.List;

import static com.charniauski.training.horsesrace.daodb.util.ReflectionUtil.getFields;
import static com.charniauski.training.horsesrace.daodb.util.ReflectionUtil.getTableName;

/**
 * Created by Andre on 22.10.2016.
 */

public class SqlBuilder {

    private static final Logger LOGGER = LoggerFactory.getLogger(SqlBuilder.class);

    public static <T extends AbstractModel> String sqlSelectEntity(Class<T> clazz) {
        return "SELECT * FROM " + getTableName(clazz) + " ";
    }

    public static <T extends AbstractModel> String sqlDeleteEntity(Class<T> clazz) {
        return "DELETE FROM " + getTableName(clazz) + " WHERE id =";
    }

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
                if (isInsert && entityAnnotation.autoincrementColumn().equals(field.getName())) continue;
                if (field.getType().getSimpleName().endsWith("String") /*||field.getType().getSimpleName().endsWith("Boolean")*/
                        ||field.getType().getSimpleName().endsWith("Date") ||field.getType().isEnum()) {
                    if (field.get(entity) == null) continue;
                    else valueSb.append("'").append(field.get(entity)).append("', ");
                } else {
                    valueSb.append(field.get(entity)).append(", ");
                }
                columnSb.append(column.columnName()).append(", ");
            }
            if (isInsert) {
                valueSb.deleteCharAt(valueSb.lastIndexOf(",")).deleteCharAt(valueSb.lastIndexOf(" "))
                        .append("); ");
                columnSb.deleteCharAt(columnSb.lastIndexOf(",")).deleteCharAt(columnSb.lastIndexOf(" "))
                        .append(") ")
                        .append(valueSb.toString());
            } else {
                valueSb.deleteCharAt(valueSb.lastIndexOf(",")).deleteCharAt(valueSb.lastIndexOf(" "))
                        .append(") WHERE id=")
                        .append(fieldId.get(entity))
                        .append(";");
                columnSb.deleteCharAt(columnSb.lastIndexOf(",")).deleteCharAt(columnSb.lastIndexOf(" "))
                        .append(") ")
                        .append(valueSb.toString());
            }
        } catch (IllegalArgumentException | IllegalAccessException e) {
            LOGGER.error("Field error",e);
            e.printStackTrace();
        }
        return columnSb.toString();
    }

}
