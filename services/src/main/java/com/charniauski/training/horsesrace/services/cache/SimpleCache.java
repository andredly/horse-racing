package com.charniauski.training.horsesrace.services.cache;

//import com.hp.cache4guice.adapters.CacheAdapter;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.sql.Connection;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
        import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class SimpleCache implements Cacheable {

    private ExecutorService executorService;

    private Map<String, Map<Object,Date>> cache;

    private static final int DEFAULT_TIME_TO_LIFE_SECOND =5*60*60;
    private static final int DEFAULT_SIZE=1000;
//    private Map<String, Object> cache;
    private int timeToLiveSeconds=5*60*60;
    private int size=500;

    public SimpleCache() {
        this(DEFAULT_TIME_TO_LIFE_SECOND,DEFAULT_SIZE);
    }

    public SimpleCache(int timeToLiveSeconds, int size) {
        cache = new ConcurrentHashMap<>();
        this.timeToLiveSeconds = timeToLiveSeconds;
        this.size=size;
        this.executorService= Executors.newSingleThreadExecutor();
    }

    @Override
    public Object get(String key) {
        return cache.get(key);
    }

    @Override
    public void put(String key, Object value) {
        if (isFull()){clear();}
        Map<Object,Date> map=new HashMap<>();
        put(key, map.put(value, new Date()));
    }

    public boolean isKeyInCache(String key) {
        return cache.keySet().contains(key);
    }


    public boolean isFull() {
        return cache.size()>size*0.75;
    }

    public void clearAll(){
        cache.clear();
    }

    public void clear() {
        executorService.submit(new ClearCache());
    }

    private class ClearCache implements Callable {

        @Override
        public Void call() throws Exception {
            Map<String,Map<Object,Date>> newMap=new ConcurrentHashMap<>(cache);
            Calendar instance = Calendar.getInstance();
            instance.setTime(new Date());
            instance.roll(Calendar.SECOND,-timeToLiveSeconds);
            for (Map.Entry<String,Map<Object,Date>> map:newMap.entrySet()){
                for (Map.Entry<Object,Date> mapObj:map.getValue().entrySet()){
                    if (instance.getTime().after(mapObj.getValue())){cache.remove(map.getKey());}
                }
            }
            return null;
        }
    }


}