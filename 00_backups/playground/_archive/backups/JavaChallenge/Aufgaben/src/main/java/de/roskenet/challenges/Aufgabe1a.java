package de.roskenet.challenges;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

public class Aufgabe1a {
    public static int calc(final int m, final int n) {
        return (m * n / 2) % 7;
    }
}

class Aufgabe1aTest {

    @Test
    void testCalc() throws Exception {
        assertThat(Aufgabe1a.calc(6, 7), is(0));
    }
}
