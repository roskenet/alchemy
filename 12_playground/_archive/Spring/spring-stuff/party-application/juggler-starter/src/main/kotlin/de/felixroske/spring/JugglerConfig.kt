package de.felixroske.spring

import de.felixroske.performer.Juggler
import de.felixroske.performer.Performer
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@AutoConfiguration
class JugglerConfig(val props: JugglerProperties) {
    @Bean
    open fun performer(): Performer = Juggler(props.item, props.num)
}