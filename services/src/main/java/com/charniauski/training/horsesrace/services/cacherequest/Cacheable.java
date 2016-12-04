package com.charniauski.training.horsesrace.services.cacherequest;

public interface Cacheable {

    Object get(String key);

    void put(String key, Object value);
    
    boolean isKeyInCache(String key);

    void put(String key, Object value, int timeToLiveSeconds);

}