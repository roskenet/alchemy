package de.felixroske.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldConfig {

    @Bean
HelloWorld helloWorld() {
        return new HelloWorldImpl();
    }
}
