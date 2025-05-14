package de.roskenet.hellospring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloSpringApplication implements CommandLineRunner {

    @Value("${myapp.message:Hello}")
    private String message;

    public static void main(String... args) {
        var applicationContext = SpringApplication.run(HelloSpringApplication.class, args);
        var displayName = applicationContext.getDisplayName();
        System.out.println(displayName);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(message + " World!");
    }
}
