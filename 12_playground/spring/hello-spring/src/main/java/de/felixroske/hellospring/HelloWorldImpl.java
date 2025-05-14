package de.felixroske.hellospring;

import org.springframework.stereotype.Component;

public class HelloWorldImpl implements HelloWorld {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello World!");
    }
}
