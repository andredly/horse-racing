package com.charniauski.training.horsesrace.services.cache;

import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class CacheAdapterSimpleCache implements Cacheable {

    @Inject
    private SimpleCache cache;


    public CacheAdapterSimpleCache() {
    }

    @Override
    public Object get(String key) {
        return cache.get(key);
    }

    @Override
    public void put(String key, Object value) {
        cache.put(key, value);
    }

    public boolean isKeyInCache(String key) {
        return cache.isKeyInCache(key);
    }

}