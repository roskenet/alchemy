package de.roskenet.riptidedemo.oxygen;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zalando.riptide.Http;

@Configuration
public class OxygenClientConfig {

    @Bean
    public OxygenClient oxygenClientTwo(@Qualifier("oxygen") Http http) {
        return new OxygenClient(http);
    }
}
