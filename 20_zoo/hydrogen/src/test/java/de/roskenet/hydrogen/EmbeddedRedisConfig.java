package de.roskenet.hydrogen;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import redis.embedded.RedisServer;

import java.io.IOException;

/**
 * Configuration for embedded Redis server.
 * <p>
 * This configuration starts an embedded Redis server for development and testing.
 * It is only active when the "default" profile is active (typically in development).
 */
@Configuration
//@Profile("development") // Only activate in development environment
public class EmbeddedRedisConfig {

    @Value("${spring.data.redis.port}")
    private int redisPort;

    private RedisServer redisServer;

    /**
     * Starts the embedded Redis server after bean initialization.
     *
     * @throws IOException if the Redis server cannot be started
     */
    @PostConstruct
    public void startRedis() throws IOException {
        redisServer = RedisServer.builder()
                .port(redisPort)
                .setting("maxmemory 128M") // Limit memory usage
                .build();
        
        try {
            redisServer.start();
        } catch (Exception e) {
            // If Redis is already running on this port, log a message but don't fail
            System.out.println("Could not start embedded Redis server: " + e.getMessage());
            System.out.println("Using existing Redis server if available.");
        }
    }

    /**
     * Stops the embedded Redis server before bean destruction.
     */
    @PreDestroy
    public void stopRedis() {
        if (redisServer != null && redisServer.isActive()) {
            redisServer.stop();
        }
    }
}