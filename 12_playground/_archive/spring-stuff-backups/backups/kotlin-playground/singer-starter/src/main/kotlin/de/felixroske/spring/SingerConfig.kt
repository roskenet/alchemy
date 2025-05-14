package de.felixroske.spring

import de.felixroske.performer.Performer
import de.felixroske.performer.Singer
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.context.annotation.Bean

@AutoConfiguration
open class SingerConfig {

    @Bean
    open fun performer(): Performer = Singer()
}