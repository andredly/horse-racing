package com.charniauski.training.horsesrace.services.cache;

import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

//@Service
public class SimpleCache1 implements Cacheable {


    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleCache1.class);
//    org.clapper.util.misc
//    Класс FileHashMap <K, V>

    private ExecutorService executorService;
    private Map<String, Map<Object, Date>> cache;
    private static final int DEFAULT_TIME_TO_LIFE_SECOND = 30;
    private static final int DEFAULT_SIZE = 1000;
    private volatile boolean flagClearCache;
    private boolean flagStopCaching;
    private int timeToLiveSeconds;
    private int size;

    public SimpleCache1() {
        this(DEFAULT_TIME_TO_LIFE_SECOND, DEFAULT_SIZE);
    }

    public SimpleCache1(int timeToLiveSeconds, int size) {
        cache = new ConcurrentHashMap<>();
        this.timeToLiveSeconds = timeToLiveSeconds;
        this.executorService = Executors.newSingleThreadExecutor();
        this.size = size;
        this.flagClearCache = false;
        this.flagStopCaching = false;
    }

    @Override
    public Object get(String key) {
        if (flagStopCaching) {
            return null;
        }
        Object obj = cache.get(key).keySet().iterator().next();
        LOGGER.debug("Get " + obj);
        return obj;

    }

    @Override
    public void put(String key, Object value) {
        if (flagStopCaching) {
            return;
        }
        if (flagClearCache) {
            return;
        }
        if (isFull()) {
            return;
        }
        Map<Object, Date> map = new HashMap<>();
        map.put(value, new Date());
        LOGGER.info("Put " + map);
        cache.put(key, map);
    }

    public boolean isKeyInCache(String key) {
        return cache.keySet().contains(key);
    }

    private boolean isFull() {
        if (cache.size() > size * 1.2) {
            this.clearAll();
            return true;
        }
        if (cache.size() > size * 0.75) {
            this.clear();
            return true;
        }
        return false;
    }

    public void clearAll() {
        stopCaching();
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            LOGGER.error("Interrupted",e);
            e.printStackTrace();
        }
        cache.clear();
        startCaching();
        LOGGER.info("All cache cleaning is completed");
    }


    private void clear() {
        Validate.notNull(executorService);
        executorService.submit(new ClearCache());
    }

    public void startClear() {
        flagStopCaching = true;
        if (executorService == null) {
            this.executorService = Executors.newSingleThreadExecutor();
        }
        this.clear();
    }

    public void stopClear() {
        flagClearCache = true;
        if (executorService != null) {
            executorService.shutdown();
            try {
                executorService.awaitTermination(10, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                LOGGER.error("Thread do not stop", e);
                e.printStackTrace();
            }
            if (!executorService.isTerminated()) {
                executorService.shutdownNow();
            }
        }
    }

    public void serialize(String path) throws IOException {
        stopClear();
        stopCaching();
        try (ObjectOutput objectOutput = new ObjectOutputStream(new FileOutputStream(new File(path)))) {
            objectOutput.writeObject(cache);
        }
    }

    public Map<String, Map<Object, Date>> deserialize(String path) throws IOException {
        stopClear();
        stopCaching();
        File file = new File(path);
        if (!file.exists())file.createNewFile();
        try (ObjectInput objectInput = new ObjectInputStream(new FileInputStream(file))) {
            try {
                cache = (Map<String, Map<Object, Date>>) objectInput.readObject();
            } catch (ClassNotFoundException e) {
                LOGGER.error("Class not found", e);
                e.printStackTrace();
            }
        }
        stopCaching();
        stopClear();
        return cache;
    }

    public void stopCaching() {
        flagStopCaching = true;
    }

    public void startCaching() {
        flagStopCaching = false;
    }

    private class ClearCache implements Callable {

        @Override
        public Void call() throws Exception {
            flagClearCache = true;
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
            LOGGER.info("Cache cleaning is completed");
            flagClearCache = false;
            return null;
        }
    }


}