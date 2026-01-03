package workshop.spring.beans;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import workshop.performer.Performer;

@AutoConfiguration
public class JugglerConfig {

    @Bean
    public Performer juggler() {
        return new Juggler();
    }

}
