package de.felixroske.spring

import de.felixroske.performer.Juggler
import de.felixroske.performer.Performer
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.context.annotation.Bean

@AutoConfiguration
open class JugglerConfig{

    @Bean
    open fun performer(): Performer = Juggler()
}