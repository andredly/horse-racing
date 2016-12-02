package com.charniauski.training.horsesrace.web.converter;

import com.charniauski.training.horsesrace.daodb.util.NullAwareBeanUtilsBean;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.Map;

/**
 * Created by ivc4 on 25.11.2016.
 */
@Component
public abstract class AbstractConverter <T,D> implements GenericConverter<T,D> {

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
        return (T) getBean(dto, clazzT);
    }

    @SuppressWarnings("unchecked")
    @Override
    public D toDTO(T entity) {
        return (D) getBean(entity, clazzD);
    }


    private Object getBean(Object object, Class<?> clazz) {
        Map<String, Object> describe;
        try {
            describe = PropertyUtils.describe(object);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            LOGGER.error("",e);
            return null;
        }
        BeanUtilsBean instance = NullAwareBeanUtilsBean.getInstance();
        Object entity;
        try {
            entity = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            LOGGER.error("",e);
            return null;
        }
        try {
            instance.populate(entity,describe);
        } catch (IllegalAccessException | InvocationTargetException e) {
            LOGGER.error("",e);
            return null;
        }
        return entity;
    }
}
