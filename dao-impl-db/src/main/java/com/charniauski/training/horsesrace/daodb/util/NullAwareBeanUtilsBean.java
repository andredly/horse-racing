package com.charniauski.training.horsesrace.daodb.util;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class NullAwareBeanUtilsBean extends BeanUtilsBean {

        private static NullAwareBeanUtilsBean nullAwareBeanUtilsBean;
        public static NullAwareBeanUtilsBean getInstance() {
            if (nullAwareBeanUtilsBean == null) {
                nullAwareBeanUtilsBean = new NullAwareBeanUtilsBean();
            }
            return nullAwareBeanUtilsBean;
        }
        private final Log log = LogFactory.getLog(BeanUtils.class);

        @Override
        public void populate(final Object bean, final Map<String, ? extends Object> properties)
                throws IllegalAccessException, InvocationTargetException {
            if ((bean == null) || (properties == null))  {return;}
            if (log.isDebugEnabled()) {
                log.debug("BeanUtils.populate(" + bean + ", " +
                        properties + ")");
            }
            for (final Map.Entry<String, ? extends Object> entry : properties.entrySet()) {
                final String name = entry.getKey();
                if (name == null) {continue;}
                if (entry.getValue() == null){ continue;}
                super.setProperty(bean, name, entry.getValue());
            }
        }
    }