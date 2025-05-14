package de.roskenet;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");

        var executeMe = executeMe(SomeFunction::doSomething, "Hello World");

        System.out.println(executeMe);
    }

    public static String executeMe(Function<String, String> function, String input) {
       return function.apply(input);
    }
}