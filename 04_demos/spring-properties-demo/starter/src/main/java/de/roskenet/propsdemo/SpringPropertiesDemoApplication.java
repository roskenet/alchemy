package de.roskenet.propsdemo;

import de.roskenet.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication( scanBasePackages = "de.roskenet")
public class SpringPropertiesDemoApplication implements CommandLineRunner {

    @Autowired
    private Application application;

    public static void main(String[] args) {
        SpringApplication.run(SpringPropertiesDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
       application.doSomething();
    }
}
