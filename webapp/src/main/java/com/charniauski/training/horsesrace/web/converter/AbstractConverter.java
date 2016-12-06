package com.charniauski.training.horsesrace.web.converter;

import com.charniauski.training.horsesrace.daodb.util.NullAwareBeanUtilsBean;
import com.charniauski.training.horsesrace.daodb.util.ReflectionUtil;
import com.charniauski.training.horsesrace.web.anotation.I18n;
import com.charniauski.training.horsesrace.web.anotation.Language;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ivc4 on 25.11.2016.
 */
@Component
public abstract class AbstractConverter<T, D> implements GenericConverter<T, D> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractConverter.class);

    private final Class<T> clazzT;
    private final Class<D> clazzD;

    @SuppressWarnings("unchecked")
    AbstractConverter() {
        this.clazzT = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        this.clazzD = (Class<D>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    @SuppressWarnings("unchecked")
    @Override
    public T toEntity(D dto) {
        return (T) getBean(dto, clazzT, null);
    }

    @SuppressWarnings("unchecked")
    @Override
    public D toDTO(T entity) {
        return (D) getBean(entity, clazzD, null);
    }

    @SuppressWarnings("unchecked")
    @Override
    public D toDTO(T entity, String language) {
        return (D) getBean(entity, clazzD, language);
    }


    private Object getBean(Object object, Class<?> clazz, String language) {
        Map<String, Object> describe;
        Object entity;
        try {
            describe = PropertyUtils.describe(object);
            if (clazzT.isInstance(object)) {
                filterLanguageField(describe, (T) object, language);
            }
            BeanUtilsBean instance = NullAwareBeanUtilsBean.getInstance();
            try {
                entity = clazz.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                LOGGER.error("", e);
                return null;
            }
            instance.populate(entity, describe);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            LOGGER.error("", e);
            return null;
        }
        return entity;
    }


    private void filterLanguageField(Map<String, Object> describe, T entity, String lang) {
        if (lang == null) {
            lang = Language.EN.name();
        }
        Field[] declaredFields = clazzD.getDeclaredFields();
        for (Field field : declaredFields) {
            I18n annotation = field.getAnnotation(I18n.class);
            if (annotation != null) {
                Language language = annotation.language();
                if (!lang.equals(language.name())) {
                    describe.remove(field.getName());
//                    describe.put(field.getName(), null);
                }
            }
        }
    }
}
