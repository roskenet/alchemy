package org.example.cachedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableCaching
@EnableScheduling
public class CacheDemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CacheDemoApplication.class, args);
    }

    @Autowired
    private SomethingCache cache;

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("Hello World");

        cache.transformMe("Irgendwas");

        Thread.sleep(1000);

        cache.transformMe("Irgendwas");

        Thread.sleep(5000);

        cache.transformMe("Irgendwas");

    }

    @Autowired
    private CacheManager cacheManager;

    @Scheduled(fixedRate = 1000)
    public void bruteForceEviction() {
//        com.google.common.cache.Cache theCache = (com.google.common.cache.Cache) googleCache.getNativeCache();
//
//        long size = theCache.size();
//        System.out.println("We have " + size + " entries");
//        googleCache.clear();
        for (String name : cacheManager.getCacheNames()) {
            System.out.println("Cache: " + name);
            cacheManager.getCache(name).clear();
        }
    }
}
