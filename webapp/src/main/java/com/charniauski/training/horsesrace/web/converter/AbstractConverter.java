package com.charniauski.training.horsesrace.web.converter;

import com.charniauski.training.horsesrace.daodb.util.NullAwareBeanUtilsBean;
import com.charniauski.training.horsesrace.web.anotation.I18n;
import com.charniauski.training.horsesrace.web.anotation.Language;
import com.charniauski.training.horsesrace.web.corrector_dto.AbstractCorrector;
import com.charniauski.training.horsesrace.web.corrector_dto.CorrectorDTOForRole;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
        return toDTO(entity, null);
    }

    @SuppressWarnings("unchecked")
    @Override
    public D toDTO(T entity, String language) {
        D dto = (D) getBean(entity, clazzD, language);
        return (D) getCorrectorDTOForRole().getDTOForRole(dto,getCorrectorDTOForRole().getRole());
    }


    private Object getBean(Object object, Class<?> clazz, String language) {
        Map<String, Object> describe;
        Object entity;
        try {
            describe = PropertyUtils.describe(object);
            if (clazzT.isInstance(object)) {
                filterLanguageField(describe, language);
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


    private void filterLanguageField(Map<String, Object> describe, String lang) {
        Set<String> setLang=new HashSet<>();
        if (lang == null) {
            setLang.add(Language.EN.name());
        }else {
            setLang.addAll(Arrays.asList(lang.split(",")));
        }
        Field[] declaredFields = clazzD.getDeclaredFields();
        for (Field field : declaredFields) {
            I18n annotation = field.getAnnotation(I18n.class);
            if (annotation != null) {
                Language language = annotation.language();
                if (!setLang.contains(language.name())) {
                    describe.remove(field.getName());
                }
            }
        }
    }

    abstract CorrectorDTOForRole getCorrectorDTOForRole();
}
