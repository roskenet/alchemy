package de.roskenet.hydrogen;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

/**
 * Configuration for Spring Session with Redis.
 * <p>
 * This class configures Spring Session to use Redis as the session store.
 * The actual connection properties are defined in application.properties.
 */
@Configuration
@EnableRedisHttpSession
public class SessionConfig {
}