package com.charniauski.training.horsesrace.services.cache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheException;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

@Service
public class CacheAdapterEhcache implements Cacheable {

    private Cache cache;

    @Named("timeToLiveSeconds")
    private int timeToLiveSeconds;
//    @Inject
//    public CacheAdapterEhcache(CacheManager cacheManager) {
//        cache = cacheManager.getCache("DB");
//        System.out.println(cache);
//        if (cache==null) {
//            cacheManager.addCache("DB");
//            cache = cacheManager.getCache("DB");
//        }
//        System.out.println(cache);
//    }

    @Override
    public Object get(String key) {
        Element element = cache.get(key);
        return element == null ? null : element.getObjectValue();
    }

    @Override
    public void put(String key, Object value)
    {
        System.out.println(timeToLiveSeconds);
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


    public void setDisabled() {
        cache.getCacheManager().removeCache("DB");

    }
    @Inject
    Cache getCache(org.springframework.cache.CacheManager cacheManager){
        return (Cache) cacheManager.getCache("DB");
    }


}