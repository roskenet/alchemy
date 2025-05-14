package org.example;

public class MyException extends RuntimeException {

    private final String msg;

    public MyException(String msg) {
        this.msg = msg;
    }

    public void echo() {
        System.out.println("I am MyException");
    }
}
