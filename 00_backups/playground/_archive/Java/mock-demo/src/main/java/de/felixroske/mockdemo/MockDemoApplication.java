package de.felixroske.mockdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MockDemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MockDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello World!");

        Dog dog = new Dog();
        dog.move(120L);
    }

    public static void doSomething(Moveable theMoveable) {
        theMoveable.move(12345L);
    }
}
