package de.roskenet.playground;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

public class ModuloPlayground {

    public static int extractLastDigit(int number) {
        return number % 10;
    }
}

class TestModulPlayground {

    @Test
    void testExtractLastDigit() {
        assertThat(ModuloPlayground.extractLastDigit(1436), is(6));
    }
}
