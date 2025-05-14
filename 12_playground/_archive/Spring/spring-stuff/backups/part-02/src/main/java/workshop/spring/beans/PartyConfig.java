package workshop.spring.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PartyConfig {

    @Bean
    public Performer juggler() {
        return new Juggler();
    }

    @Bean
    public Party summerParty(Performer performer) {
        return new SummerParty(performer);
    }
}
