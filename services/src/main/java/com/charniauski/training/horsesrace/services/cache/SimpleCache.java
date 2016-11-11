package com.charniauski.training.horsesrace.services.cache;

import com.google.inject.Inject;
import com.google.inject.name.Named;
//import com.hp.cache4guice.adapters.CacheAdapter;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//@Service
public class SimpleCache implements Cacheable {

    private Map<String, Object> cache;
    private final int timeToLiveSeconds=600;

    public SimpleCache() {
        cache = new ConcurrentHashMap<>();
//        this.timeToLiveSeconds = Integer.parseInt(timeToLiveSeconds);
    }

    @Override
    public Object get(String key) {
        return cache.get(key);
    }

    @Override
    public void put(String key, Object value) {
        put(key, value, timeToLiveSeconds);
    }

    @Override
    public void put(String key, Object value, int timeToLiveInSeconds) {
        cache.put(key, value);
    }


    public boolean isKeyInCache(String key) {
        return cache.keySet().contains(key);
    }

}