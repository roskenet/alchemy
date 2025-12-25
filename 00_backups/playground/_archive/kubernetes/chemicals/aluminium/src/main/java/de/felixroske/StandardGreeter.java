package de.felixroske;

public class StandardGreeter implements HelloWorldGreeter {

    @Override
    public String greetMe(String name) {
        return String.format("Hello, %s!", name);
    }
}
