package com.charniauski.training.horsesrace.daodb.util;

import com.charniauski.training.horsesrace.datamodel.annotation.Column;
import com.charniauski.training.horsesrace.datamodel.annotation.Entity;
import com.charniauski.training.horsesrace.datamodel.annotation.EnumType;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.PropertyUtilsBean;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

import static org.springframework.util.Assert.notNull;

public class ReflectionUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReflectionUtil.class);

    public static <T> T getBean(Map<String, Object> mapResultQuery, Class<T> clazz) {
        Map<String, Object> beanParameter = new LinkedHashMap<>();
        List<Field> fields = getFields(clazz);
        for (Field field : fields) {
            Column column = field.getAnnotation(Column.class);
            EnumType enumType = field.getAnnotation(EnumType.class);
            if (field.getType().isEnum()) {
                String enumName = (String) mapResultQuery.get(column.columnName());
                Enum[] anEnum = (Enum[]) enumType.nameClass().getEnumConstants();
                for (Enum enumInstance : anEnum) {
                    if (enumInstance.name().equals(enumName)) {beanParameter.put(field.getName(), enumInstance);}
                }
                continue;
            }
            if (mapResultQuery.containsKey(column.columnName())){
                beanParameter.put(field.getName(), mapResultQuery.get(column.columnName()));}
        }
        for (Map.Entry<String, Object> map : mapResultQuery.entrySet()) {
            String columnNameChanged = map.getKey().replace("_", "").replace("_id", "");
            String nameClass = clazz.getSimpleName().toLowerCase();
            if (columnNameChanged.equals(nameClass)) {beanParameter.put("id", map.getValue());}
        }
        T entity = null;
        try {
            entity = clazz.newInstance();
            BeanUtilsBean instance = NullAwareBeanUtilsBean.getInstance();
            instance.populate(entity, beanParameter);
        } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
            LOGGER.error("Error create",e);
            e.printStackTrace();
        }
        return entity;
    }

    static <T> List<Field> getFields(Class<T> clazz) {
        List<Field> list = new ArrayList<>();
        list.addAll(Arrays.asList(clazz.getDeclaredFields()));
        ReflectionUtil.addSuperclassFields(clazz, list);
        return list;
    }

    private static <T> void addSuperclassFields(Class<T> clazz, List<Field> list) {
        if (clazz.getSuperclass() != null) {
            Class<?> superclass = clazz.getSuperclass();
            Field[] declaredFields = superclass.getDeclaredFields();
            List<Field> listNew = new ArrayList<>(Arrays.asList(declaredFields));
            list.addAll(listNew);
            ReflectionUtil.addSuperclassFields(superclass.getSuperclass(), list);
        }
    }

    static <T> String getTableName(Class<T> clazz) {
        Entity annotation = clazz.getAnnotation(Entity.class);
        notNull(annotation);
        return annotation.tableName();
    }

    public static <T> List<Column> getColumns(Class<T> clazz) {
        List<Column> columns = new ArrayList<>();
        Entity annotation = clazz.getAnnotation(Entity.class);
        notNull(annotation);
        List<Field> fields = ReflectionUtil.getFields(clazz);
        if (fields.isEmpty()) return columns;
        for (Field field : fields) {
            Column column = field.getAnnotation(Column.class);
            columns.add(column);
        }
        return columns;
    }

}
