package com.charniauski.training.horsesrace.web.converter.fabric;

import com.charniauski.training.horsesrace.datamodel.Account;
import com.charniauski.training.horsesrace.web.converter.AccountConverter;
import com.charniauski.training.horsesrace.web.converter.GenericConverter;
import com.google.inject.Inject;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import static org.apache.logging.log4j.web.WebLoggerContextUtils.getServletContext;

/**
 * Created by Andre on 11.12.2016.
 */
//@Component
public class ConverterFactoryImpl implements ConverterFactory {


    @Override
    public GenericConverter getConverter(Class targetType) {

        WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
               Object bean = context.getBean(targetType);
        System.out.println(bean);
        System.out.println("Прокатило");
        return null;
    }
}
