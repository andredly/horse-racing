package com.charniauski.training.horsesrace.services.cache;

import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class CacheAdapterSimpleCache implements Cacheable {

    @Inject
    private SimpleCache cache;


    public CacheAdapterSimpleCache() {
    }

    //    @Named("timeToLiveSeconds")
    private int timeToLiveSeconds;
//    @Inject
//    public CacheAdapter(CacheManager cacheManager) {
//        System.out.println(cacheManager);
//        cache = cacheManager.getCache("DB");
//        if (cache==null) {
//            cacheManager.addCache("DB");
//            cache = cacheManager.getCache("DB");
//        }
//        System.out.println(cache.getStatus());
//    }

    @Override
    public Object get(String key) {
        Object element = cache.get(key);
        return element == null ? null : element;
    }

    @Override
    public void put(String key, Object value)
    {
        System.out.println(timeToLiveSeconds);
        put(key, value, timeToLiveSeconds);
    }

    @Override
    public void put(String key, Object value, int timeToLiveInSeconds) {
        cache.put(key,value,timeToLiveInSeconds);
    }

    public boolean isKeyInCache(String key) {
        return cache.isKeyInCache(key);
    }


}