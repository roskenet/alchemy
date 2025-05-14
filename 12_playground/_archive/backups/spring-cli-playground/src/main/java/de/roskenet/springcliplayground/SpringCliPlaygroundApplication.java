package de.roskenet.springcliplayground;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringCliPlaygroundApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringCliPlaygroundApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello World!");
    }
}
