package de.roskenet.pg.springpg;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class SpringPgApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringPgApplication.class, args);
    }

    class MyObject {
        String someString;
    }


    @Override
    public void run(String... args) throws Exception {

        MyObject theObj = null;

        log.debug("Is this null-safe {} ", theObj.someString);
    }
}
