package com.charniauski.training.horsesrace.services.cache;

public interface Cacheable {

    Object get(String key);

    void put(String key, Object value);

    void put(String key, Object value, int timeToLiveInSeconds);
    
    boolean isKeyInCache(String key);

}