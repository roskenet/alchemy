package org.example;

public class MyClass {

    public String doSomething(Boolean throwSomething) {
        if (throwSomething) {

            RuntimeException testRuntimeException = new RuntimeException(new RuntimeException("MyException"));

            throw testRuntimeException;
        }
        else {
            return "Done!";
        }
    }

}
