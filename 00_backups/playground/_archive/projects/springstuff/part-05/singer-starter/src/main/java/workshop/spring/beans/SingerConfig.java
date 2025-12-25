package workshop.spring.beans;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import workshop.performer.Performer;


@AutoConfiguration
public class SingerConfig {

    @Bean
    public Performer singer() {
        return new Singer();
    }

}
