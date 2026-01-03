package de.zalando.workshop;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloWorldTest {

    @Test
    void testDoSomething() {
        final String amazingString = "MyAmazingString";

        final String result = amazingString.toUpperCase();

        assertThat(result).isEqualTo("MYAMAZINGSTRING");
    }

}
