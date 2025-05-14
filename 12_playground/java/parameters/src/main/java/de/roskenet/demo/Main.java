package de.roskenet.demo;

import java.util.ArrayList;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        Collection<? extends Animal> animals = new ArrayList<>();

        Dog dog = new Dog("Fido");

        animals.add(dog);

    }
}