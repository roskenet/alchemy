package de.roskenet.kotlinspring

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class KillerAppConfig {

    @Bean
    fun killerApplication() : KillerApplication {
        return KillerApplication()
    }
}