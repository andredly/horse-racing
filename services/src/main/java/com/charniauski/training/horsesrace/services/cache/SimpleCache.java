package com.charniauski.training.horsesrace.services.cache;


import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class SimpleCache implements Cacheable {

    private ExecutorService executorService;

    private Map<String, Map<Object, Date>> cache;

    private static final int DEFAULT_TIME_TO_LIFE_SECOND = 30;
    private static final int DEFAULT_SIZE = 1000;
    private volatile boolean flagClearCache;
    private int timeToLiveSeconds;
    private int size;

    public SimpleCache() {
        this(DEFAULT_TIME_TO_LIFE_SECOND, DEFAULT_SIZE);
    }

    public SimpleCache(int timeToLiveSeconds, int size) {
        cache = new ConcurrentHashMap<>();
        this.timeToLiveSeconds = timeToLiveSeconds;
        this.size = size;
        this.executorService = Executors.newSingleThreadExecutor();
        this.flagClearCache=false;
    }

    @Override
    public Object get(String key) {
        Object obj = cache.get(key).keySet().iterator().next();
        return obj;
    }

    @Override
    public void put(String key, Object value) {
        if(flagClearCache){return;}
        if (isFull()){return;}
        Map<Object, Date> map = new HashMap<>();
        map.put(value, new Date());
        cache.put(key, map);
    }

    public boolean isKeyInCache(String key) {
        return cache.keySet().contains(key);
    }

    private boolean isFull() {
        if (cache.size() > size*1.2) { clearAll();
            return true;
        }
        if (cache.size() > size*0.75){clear();
            return true;
        }
        return false;
    }

    public void clearAll() {
        cache.clear();
    }


    public void clear() {
        executorService.submit(new ClearCache());
    }

    private class ClearCache implements Callable {

        @Override
        public Void call() throws Exception {
            flagClearCache=true;
            Map<String, Map<Object, Date>> newMap = new ConcurrentHashMap<>(cache);
            Calendar instance = Calendar.getInstance();
            instance.setTime(new Date());
            instance.roll(Calendar.SECOND, -timeToLiveSeconds);
            for (Map.Entry<String, Map<Object, Date>> map : newMap.entrySet()) {
                for (Map.Entry<Object, Date> mapObj : map.getValue().entrySet()) {
                    if (instance.getTime().after(mapObj.getValue())) {
                        cache.remove(map.getKey());
                    }
                }
            }
            newMap.clear();
            flagClearCache=false;
            return null;
        }
    }

}