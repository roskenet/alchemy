package de.roskenet.demo;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        Map<String, String> theMap = new HashMap<>();

        theMap.put("Hello", "World");
        theMap.put("Hello2", "World2");

        theMap.forEach((k, v) -> System.out.println(k + " : " + v));
    }
}