package org.example;

public class MySubException extends MyException {

    public MySubException(String msg) {
        super(msg);
    }

    public void echo() {
        System.out.println("I am MySubException");
    }
}
