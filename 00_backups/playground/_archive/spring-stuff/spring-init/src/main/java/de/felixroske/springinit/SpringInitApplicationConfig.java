package de.felixroske.springinit;

import de.felixroske.springinit.killerapp.KillerApp;
import de.felixroske.springinit.killerapp.StringUppercaser;
import org.springframework.context.annotation.Bean;

public class SpringInitApplicationConfig {

    @Bean
    public KillerApp killerApp() {
        return new StringUppercaser();
    }
}
