package de.felixroske.springinit.killerapp;

import org.springframework.boot.CommandLineRunner;

import java.util.Locale;

public class StringUppercaser implements KillerApp, CommandLineRunner {
    @Override
    public String doSomething(String param) {
        return param.toUpperCase(Locale.GERMAN);
    }

    @Override
    public void run(String... args) throws Exception {
        var result = doSomething("hello world");
        System.out.println(result);
    }
}
