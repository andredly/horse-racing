package com.charniauski.training.horsesrace.services.appender;



import org.apache.commons.dbcp.DriverManagerConnectionFactory;

import java.util.Properties;

/**
 * Created by ivc4 on 09.11.2016.
 */
class CustomDriverConnectionFactory extends DriverManagerConnectionFactory {

    public CustomDriverConnectionFactory(Properties fullProps) {
        super(fullProps.getProperty("jdbc.url"),fullProps.getProperty("jdbc.username"),fullProps.getProperty("jdbc.password"));
    }
}
