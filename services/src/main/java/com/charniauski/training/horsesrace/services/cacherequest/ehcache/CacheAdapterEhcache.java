package com.charniauski.training.horsesrace.services.cacherequest.ehcache;

import com.charniauski.training.horsesrace.services.cacherequest.Cacheable;
import com.charniauski.training.horsesrace.services.cacherequest.SimpleCache;
import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import javax.inject.Inject;
import java.io.IOException;

//@Service
public class CacheAdapterEhcache implements Cacheable {

    private static final Logger LOGGER = LoggerFactory.getLogger(CacheAdapterEhcache.class);
    @Inject
    private Cache cache;

    @Value("${timeToLiveSeconds}")
    int timeToLiveSeconds;

    @Override
    public Object get(String key) {
        Element element = cache.get(key);
        LOGGER.info("Get value={}", element);
        return element == null ? null : element.getObjectValue();
    }

    @Override
    public void put(String key, Object value) {
        put(key, value, timeToLiveSeconds);
    }

    @Override
    public void put(String key, Object value, int timeToLiveInSeconds) {
        if (timeToLiveInSeconds == 0) {
            timeToLiveInSeconds = this.timeToLiveSeconds;
        }
        Element element = new Element(key, value, 0, timeToLiveInSeconds);
        cache.put(element);
        LOGGER.info("Put value={}", element);

    }

    @Override
    public void serialize(String path) throws IOException {
//        cache.flush();
        cache.dispose();
    }

    public boolean isKeyInCache(String key) {
        return cache.isKeyInCache(key);
    }

}