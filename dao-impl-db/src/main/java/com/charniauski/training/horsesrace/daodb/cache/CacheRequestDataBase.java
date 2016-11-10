package com.charniauski.training.horsesrace.daodb.cache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import javax.inject.Inject;
import javax.inject.Named;


public class CacheRequestDataBase implements Cacheable {

    @Inject
    private CacheManager cacheManager;

    private final Cache cache;

    @Named("timeToLiveSeconds")
    private int timeToLiveSeconds;

    public CacheRequestDataBase() {
        cache = cacheManager.getCache("DB");
    }

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
        Element element = new Element(key, value, Boolean.FALSE, 0, timeToLiveInSeconds);
        cache.put(element);
    }

    public boolean isKeyInCache(String key) {
        return cache.isKeyInCache(key);
    }
}