package de.felixroske;

import java.util.List;

public class MyApi
{
    public static void doSomething(List<String> theStringList) {
        theStringList.forEach(s -> System.out.println(s.toUpperCase()));
    };
}
