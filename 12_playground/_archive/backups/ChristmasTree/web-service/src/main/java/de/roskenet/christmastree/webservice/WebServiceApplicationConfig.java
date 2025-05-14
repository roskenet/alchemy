package de.roskenet.christmastree.webservice;

import de.roskenet.christmastree.ChristmasTreeNursery;
import de.roskenet.christmastree.StringChristmasTreeNursery;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebServiceApplicationConfig {

    @Bean
    public ChristmasTreeNursery nursery() {
        return new StringChristmasTreeNursery();
    }
}
