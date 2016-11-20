package com.charniauski.training.horsesrace.services.cache.ehcache;

import com.charniauski.training.horsesrace.services.cache.Cacheable;
import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class CacheAdapterEhcache implements Cacheable {

    @Inject
    private Cache cache;

    @Value("${timeToLiveSeconds}")
    int timeToLiveSeconds;

    @Override
    public Object get(String key) {
        Element element = cache.get(key);
        return element == null ? null : element.getObjectValue();
    }

    @Override
    public void put(String key, Object value) {
        put(key, value, timeToLiveSeconds);
    }

    @Override
    public void put(String key, Object value, int timeToLiveInSeconds) {
        Element element = new Element(key, value, 0, timeToLiveInSeconds);
        cache.put(element);
    }

    public boolean isKeyInCache(String key) {
        return cache.isKeyInCache(key);
    }

}