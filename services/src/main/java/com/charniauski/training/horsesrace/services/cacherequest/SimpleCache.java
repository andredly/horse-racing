package com.charniauski.training.horsesrace.services.cacherequest;

import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.Map;
import java.util.concurrent.*;

//@Service
public class SimpleCache implements Cacheable {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleCache.class);

    private ExecutorService executorService;
    private Map<String, Object[]> cache;
    private volatile boolean flagClearCache;
    private boolean flagStopCaching;
    @Value("${timeToLiveSeconds}")
    private int timeToLiveSeconds;
    @Value("${maxEntriesLocalHeap}")
    private int maxEntriesLocalHeap;

    @PostConstruct
    void init() throws IOException {
        deserialize("D://server_cache/cache.dat");
    }

//    private static final int DEFAULT_TIME_TO_LIFE_SECOND = 5 * 60;
//    private static final int DEFAULT_SIZE = 1000;

//    public SimpleCache() {
//        this(DEFAULT_TIME_TO_LIFE_SECOND, DEFAULT_SIZE);
//    }

//    public SimpleCache(int timeToLiveSeconds,int size) {
//        cache = new ConcurrentHashMap<>();
//        this.timeToLiveSeconds = timeToLiveSeconds;
//        this.executorService = Executors.newCachedThreadPool();
//        this.size = size;
//        this.flagClearCache = false;
//        this.flagStopCaching = false;
//    }

    public SimpleCache() {
        cache = new ConcurrentHashMap<>();
        this.executorService = Executors.newCachedThreadPool();
        this.flagClearCache = false;
        this.flagStopCaching = false;
        LOGGER.info("Start caching request");
    }

    @Override
    public Object get(String key) {
        Object obj = cache.get(key)[0];
        LOGGER.info("Get value={}", obj);
        return obj;
    }

    @Override
    public void put(String key, Object value) {
        put(key, value, timeToLiveSeconds);
    }

    @Override
    public void put(String key, Object value, int timeToLiveSeconds) {
        if (flagStopCaching || flagClearCache || isFull()) {
            return;
        }
        if (timeToLiveSeconds == 0) {
            timeToLiveSeconds = this.timeToLiveSeconds;
        }
        Object[] arr = new Object[2];
        arr[0] = value;
        Long timeToLive = System.currentTimeMillis() + timeToLiveSeconds * 1000;
        arr[1] = timeToLive;
        cache.put(key, arr);
        LOGGER.info("Put value={}", value);
    }

    @Override
    public boolean isKeyInCache(String key) {
        if (flagStopCaching) {
            return false;
        }
        if (cache.keySet().contains(key)) {
            Long timePutValue = (Long) cache.get(key)[1];
            if (System.currentTimeMillis() > timePutValue) {
                LOGGER.debug("Delete {}", cache.get(key));
                cache.remove(key);
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    private boolean isFull() {
        if (cache.size() > maxEntriesLocalHeap * 1.1) {
            this.clearAll();
            return true;
        }
        if (cache.size() > maxEntriesLocalHeap * 0.75) {
            this.clear();
            return true;
        }
        return false;
    }

    public void clearAll() {
        stopCaching();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            LOGGER.error("Interrupted", e);
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

    private void startClear() {
        flagStopCaching = true;
        if (executorService == null) {
            this.executorService = Executors.newSingleThreadExecutor();
        }
        this.clear();
    }

    private void stopClear() {
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

    @Override
    public void serialize(String path) throws IOException {
        stopClear();
        stopCaching();
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        } else {
            file.delete();
        }
        try (ObjectOutput objectOutput = new ObjectOutputStream(new FileOutputStream(new File(path)))) {
            objectOutput.writeObject(cache);
        }
    }

    @SuppressWarnings("unchecked")
    public Map<String, Object[]> deserialize(String path) throws IOException {
//        stopClear();
//        stopCaching();
        File file = new File(path);
        if (!file.exists()) {
            return cache;
        }
        try (ObjectInput objectInput = new ObjectInputStream(new FileInputStream(file))) {
            try {
                cache = (Map<String, Object[]>) objectInput.readObject();
            } catch (ClassNotFoundException e) {
                LOGGER.error("Class not found", e);
                e.printStackTrace();
            }
        }
//        startCaching();
//        startClear();
        return cache;
    }

    private void stopCaching() {
        flagStopCaching = true;
    }

    private void startCaching() {
        LOGGER.info("Start caching request");
        flagStopCaching = false;
    }

    private class ClearCache implements Callable {

        @Override
        public Void call() throws Exception {
            flagClearCache = true;
            Map<String, Object[]> newMap = new ConcurrentHashMap<>(cache);
            for (Map.Entry<String, Object[]> map : newMap.entrySet()) {
                Object[] valueAndTime = map.getValue();
                Long timePutValue = (Long) valueAndTime[1];
                if (System.currentTimeMillis() > timePutValue) {
                    LOGGER.debug("Clear {}", map.getValue()[0]);
                    cache.remove(map.getKey());
                }
            }
            newMap.clear();
            LOGGER.info("Cache cleaning is completed");
            flagClearCache = false;
            return null;
        }
    }
}