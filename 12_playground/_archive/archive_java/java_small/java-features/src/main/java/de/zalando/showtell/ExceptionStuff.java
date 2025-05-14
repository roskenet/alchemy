package de.zalando.showtell;

public class ExceptionStuff {

    public void doSomething() throws Throwable {
        System.out.println("Hello World!");
    }

    public void caller() {
        try {
            doSomething();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
