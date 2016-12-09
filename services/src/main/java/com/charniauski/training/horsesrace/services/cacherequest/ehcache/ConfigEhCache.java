package com.charniauski.training.horsesrace.services.cacherequest.ehcache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.config.CacheConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;


//@Configuration
public class ConfigEhCache {

    @Value("${timeToIdleSeconds}")
    int timeToIdleSeconds;
    @Value("${timeToLiveSeconds}")
    int timeToLiveSeconds;
    @Value("${diskSpoolBufferSizeMB}")
    int diskSpoolBufferSizeMB;
    @Value("${maxEntriesLocalHeap}")
    long maxEntriesLocalHeap;
    @Value("${maxEntriesLocalDisk}")
    long maxEntriesLocalDisk;
    @Value("${memoryStoreEvictionPolicy}")
    String memoryStoreEvictionPolicy;
    @Value("${transactionalMode}")
    String transactionalMode;
    @Value("${cacheName}")
    String cacheName;

    @Bean
    public Cache getCache() {
        CacheManager cacheManager = CacheManager.getInstance();
        Cache cache = cacheManager.getCache(cacheName);
        if (cache == null) {
            cacheManager.addCache(cacheName);
            cache = cacheManager.getCache(cacheName);
        }
        CacheConfiguration config = cache.getCacheConfiguration();
        config.setTimeToIdleSeconds(timeToIdleSeconds);
        config.setTimeToLiveSeconds(timeToLiveSeconds);
        config.setDiskSpoolBufferSizeMB(diskSpoolBufferSizeMB);
        config.setMaxEntriesLocalHeap(maxEntriesLocalHeap);
        config.setMaxEntriesLocalDisk(maxEntriesLocalDisk);
        config.setMemoryStoreEvictionPolicy(memoryStoreEvictionPolicy);
        config.setTransactionalMode(transactionalMode);
        return cache;
    }
}