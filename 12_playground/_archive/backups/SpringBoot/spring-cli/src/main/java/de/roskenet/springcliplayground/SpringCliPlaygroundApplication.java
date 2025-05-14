package de.roskenet.springcliplayground;

import javax.inject.Inject;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringCliPlaygroundApplication implements CommandLineRunner {

    @Inject
    private FlxWorker theWorker;

    public static void main(String[] args) {
        SpringApplication.run(SpringCliPlaygroundApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println(theWorker.doSomething("Hello World!"));
    }

}
