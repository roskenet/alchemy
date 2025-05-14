package org.example.cachedemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class SomethingCache {
    private static final Logger logger = LoggerFactory.getLogger(SomethingCache.class);

    @Cacheable(CacheConfig.CACHE_NAME)
    public String transformMe(String param) {
        logger.info("No cache hit for {}", param);
        return param.toUpperCase();
    }
}
