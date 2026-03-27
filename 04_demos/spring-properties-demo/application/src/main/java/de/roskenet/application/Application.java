package de.roskenet.application;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
public class Application {

    @Value("${somevalue}")
    private String someValue;

    public void doSomething() {
        System.out.println(someValue);
    }

}
