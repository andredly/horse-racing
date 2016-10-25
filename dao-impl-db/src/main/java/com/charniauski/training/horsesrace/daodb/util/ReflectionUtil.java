package com.charniauski.training.horsesrace.daodb.util;

import com.charniauski.training.horsesrace.datamodel.Column;
import com.charniauski.training.horsesrace.datamodel.Entity;
import org.springframework.util.Assert;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Anderson Braz - anderson.braz@brazoft.com.br
 */
public class ReflectionUtil {

    public static boolean isTransient(Field field) {
        return Modifier.isTransient(field.getModifiers());
    }

    public static boolean isAnnotated(Field field, Class<? extends Annotation>... classes) {
        for (Class<? extends Annotation> clazz : classes) {
            if (field.getAnnotation(clazz) != null) {
                return true;
            }
        }

        return false;
    }

    public static Field getField(Class<?> clazz, String name) {
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
        // throw new RuntimeException("Field with name " + name + " not found in class: " +
        // clazz.getName());
    }

    public static Object getValue(Object instance, Field field) {
        try {
            field.setAccessible(true);
            return field.get(instance);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void setValue(Object instance, Object value, Field field) {
        try {
            field.setAccessible(true);
            field.set(instance, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void setValue(String name, Object value, Object instance) {
        Field field;

        field = ReflectionUtil.getField(instance.getClass(), name);
        ReflectionUtil.setValue(instance, value, field);
    }

    public static Object getValue(String name, Object instance) {
        Field field;

        field = ReflectionUtil.getField(instance.getClass(), name);

        if (field == null) {
            return null;
        }

        return ReflectionUtil.getValue(instance, field);
    }

    /**
     * @param clazz
     * @return Returns List<Method>
     */
    public static List<Field> getFields(Class<?> clazz) {
        List<Field> list = new ArrayList<>();
        list.addAll(Arrays.asList(clazz.getDeclaredFields()));
        ReflectionUtil.addSuperclassFields(clazz, list);

        return list;
    }

    private static void addSuperclassFields(Class<?> clazz, List<Field> list) {
        if (clazz.getSuperclass() != null) {
            Class<?> superclass = clazz.getSuperclass();
            Field[] declaredFields = superclass.getDeclaredFields();
            List<Field> listNew=new ArrayList<>(Arrays.asList(declaredFields));
            list.addAll(listNew);
            ReflectionUtil.addSuperclassFields(superclass.getSuperclass(), list);
        }
    }

    public static String getTableName(Class<?> clazz) {
        Entity annotation = clazz.getAnnotation(Entity.class);
        Assert.notNull(annotation);
        return annotation.tableName();
    }

    public static List<Column> getColumns(Class<?> clazz) {
        //// TODO: 24.10.2016 multithreading?
        List<Column> columns=new ArrayList<>();
        List<Field> list = new ArrayList<>();
        Entity annotation = clazz.getAnnotation(Entity.class);
        Assert.notNull(annotation);
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

}