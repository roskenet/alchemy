package demo.uranium;

import static demo.uranium.AppProfile.INTEGRATION;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@Profile(INTEGRATION)
public class SecurityNoopConfig {

    // Locally we want all endpoints to be accessible without any token.
    @Bean
    public SecurityFilterChain filterChainNoAuth(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                authorize -> authorize.anyRequest().permitAll()
        );
        return http.build();
    }
}
