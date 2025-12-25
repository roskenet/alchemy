package workshop.spring.beans;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;


@AutoConfiguration
public class PerformerConfig {

    @Bean
    public Performer killerService() {
        return new Juggler();
    }
}
