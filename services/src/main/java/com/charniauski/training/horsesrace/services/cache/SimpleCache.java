package com.charniauski.training.horsesrace.services.cache;

//import com.hp.cache4guice.adapters.CacheAdapter;
import org.apache.commons.lang3.Validate;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.sql.Connection;
import java.util.*;
import java.util.concurrent.*;

@Service
public class SimpleCache implements Cacheable {

    private ExecutorService executorService;

    private Map<String, Map<Object,Date>> cache;

    private static final int DEFAULT_TIME_TO_LIFE_SECOND =5;
    private static final int DEFAULT_SIZE=2;
//    private Map<String, Object> cache;
    private int timeToLiveSeconds;
    private int size;

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
        Map<Object, Date> objectDateMap = cache.get(key);
        if (objectDateMap==null)return null;
        Object obj = objectDateMap.keySet().iterator().next();
        objectDateMap.put(obj,new Date());
        System.out.println("get element "+obj);
        return obj;
    }

    @Override
    public void put(String key, Object value) {
        if (isFull()){clear();
            System.out.println(size);}
        Map<Object,Date> map=new HashMap<>();
        map.put(value, new Date());
        cache.put(key, map);
        System.out.println("add element "+value);
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
                    System.out.println("clear "+mapObj.getKey());
                }
            }
            return null;
        }
    }

}