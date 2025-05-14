package de.felixroske;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        List<Integer> theIntList = new ArrayList<>();
        // Why does this show up as an error?
        // I expected type erasure in MyApi Bytecode should make this call possible?
        MyApi.doSomething(theIntList);
    }
}
