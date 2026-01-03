package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class ToArrayExample {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        ToArrayExample app = new ToArrayExample();

        List<String> stringList = new ArrayList<>();
        stringList.add("Eins");
        stringList.add("Zwei");
        stringList.add("Drei");

        app.doSomething(stringList.toArray(new String[0]));

    }

    public void doSomething(String... args) {

        for (String arg : args) {
            System.out.println(arg);
        }

    }
}
