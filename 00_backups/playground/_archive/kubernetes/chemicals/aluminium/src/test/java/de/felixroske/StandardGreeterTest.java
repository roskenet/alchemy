package de.felixroske;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class StandardGreeterTest {

    @Test
    void testGreetMeWithWorld() {
        var greeter = new StandardGreeter();

        var greeting = greeter.greetMe("World");

        assertThat(greeting).isEqualTo("Hello, World!");
    }
}