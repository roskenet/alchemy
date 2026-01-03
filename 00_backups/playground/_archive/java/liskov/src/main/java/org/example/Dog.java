package org.example;

public class Dog extends Animal {

    @Override
    public int hashCode() {
        return 2;
    }

    @Override
    public String doSomething () {
        return "This doesn't compile!";
    }
}
