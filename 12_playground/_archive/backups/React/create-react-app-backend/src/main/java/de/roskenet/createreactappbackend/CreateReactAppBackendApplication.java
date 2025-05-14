package de.roskenet.createreactappbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class CreateReactAppBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(CreateReactAppBackendApplication.class, args);
    }

}

