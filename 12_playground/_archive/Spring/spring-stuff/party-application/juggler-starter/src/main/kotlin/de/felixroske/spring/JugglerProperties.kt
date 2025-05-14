package de.felixroske.spring

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "juggler")
data class JugglerProperties(
    var item: String="Balls",
    var num: Int=2
)
