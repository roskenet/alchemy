package de.petunia.axillaris

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain

@Profile("prod", "int")
@Configuration
@EnableWebSecurity
open class SecurityConfig {
    @Bean
    open fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http.authorizeHttpRequests { requests ->
            requests.requestMatchers("/actuator/**").permitAll()
            requests.anyRequest().authenticated()
        }
        http.oauth2ResourceServer { oauth2 ->
            oauth2.jwt {}
        }
        return http.build()
    }
}
