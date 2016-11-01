package com.charniauski.training.horsesrace.daodb.util;

import com.charniauski.training.horsesrace.datamodel.AccountStatus;
import com.charniauski.training.horsesrace.datamodel.Column;
import com.charniauski.training.horsesrace.datamodel.Entity;
import com.charniauski.training.horsesrace.datamodel.SecurityLevel1;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

import static org.springframework.util.Assert.notNull;


public class ReflectionUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReflectionUtil.class);

    public static boolean isTransient(Field field) {
        return Modifier.isTransient(field.getModifiers());
    }

    public static boolean isAutoincrement(Field field) {
        Column annotation = field.getAnnotation(Column.class);
        return annotation.isAutoIncrement();
    }


    public static <T> Field getField(Class<T> clazz, String name) {
        try {
            return clazz.getDeclaredField(name);
        } catch (Exception e) {
            for (Field field : ReflectionUtil.getFields(clazz)) {
                if (field.getName().toLowerCase().equals(name.toLowerCase())) {
                    return field;
                }
            }
        }
        return null;
    }


    public static <T> List<Field> getFields(Class<T> clazz) {
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

    public static <T> String getTableName(Class<T> clazz) {
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

    public static List<Object> getBeanValue(Object entity) {
        List<Object> list = new ArrayList<>();
        List<Field> fields = getFields(entity.getClass());
        for (Field field : fields) {
            System.out.println(field);
            if (field.getName().toUpperCase().equals("id")) {
                continue;
            }
            String methodName = "get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
            System.out.println(methodName);
            try {
                if (Modifier.isStatic(field.getModifiers())) {
                    continue;
                }
                Method method = entity.getClass().getMethod(methodName);

                Object o = method.invoke(entity);
                System.out.println(o);
                if (null != o) {
                    list.add(o);
                }
            } catch (Exception e) {

            }
        }
        return list;
    }

    public static <T> T getBean(Map<String, Object> mapResultQuery, Class<T> clazz) {
        Map<String, Object> beanParameter = new LinkedHashMap<>();
        List<Field> fields = getFields(clazz);
        for (Field field : fields) {
            Column column = field.getAnnotation(Column.class);


            //// TODO: 02.11.2016
            //попробовать анотировать поле
            if (field.getType().equals(SecurityLevel1.AccountStatus1.class)) {
                String status = (String) mapResultQuery.get(column.columnName());
                SecurityLevel1.AccountStatus1 accountStatus1 = SecurityLevel1.AccountStatus1.valueOf(status);
                System.out.println(accountStatus1);
                beanParameter.put(field.getName(), accountStatus1);
                System.out.println("попал");
                continue;
            }

            if (mapResultQuery.containsKey(column.columnName()))
                beanParameter.put(field.getName(), mapResultQuery.get(column.columnName()));
        }
        LOGGER.info(beanParameter.toString());
        for (Map.Entry<String, Object> map : mapResultQuery.entrySet()) {
            String columnNameEqualsNameClass = map.getKey().replace("_", "").replace("_id", "");
            String nameClass = clazz.getSimpleName().toLowerCase();
            if (columnNameEqualsNameClass.equals(nameClass)) beanParameter.put("id", map.getValue());
        }
        T entity = null;
        try {
            entity = clazz.newInstance();
            BeanUtilsBean instance = BeanUtilsBean.getInstance();
            instance.populate(entity, beanParameter);
        } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
        return entity;
    }


    public static <T> Map<String, Object> getMapColumnAndArgEntity(T entity) {
        Map<String, Object> map = new LinkedHashMap<>();
        Class<?> clazz = entity.getClass();
        Entity entityAnnotation = clazz.getAnnotation(Entity.class);
        List<Field> allFields = ReflectionUtil.getFields(clazz);
        try {
            for (Field field : allFields) {
                field.setAccessible(true);
                Column column = field.getAnnotation(Column.class);
//                if (entityAnnotation.autoincrementColumn().equals(field.getName())) {
//                    continue;
//                }
                if (field.getType().getSimpleName().endsWith("String") || field.getType().getSimpleName().endsWith("Date")) {

                    if (field.get(entity) == null) {
                        continue;
                    } else {
                        map.put(column.columnName(), field.get(entity));
                    }

                } else {
                    map.put(column.columnName(), field.get(entity));
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return map;
    }

}
