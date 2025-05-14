package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        var dog = new Dog();

        dog.doSomething();

        System.out.println(dog.hashCode());
    }
}