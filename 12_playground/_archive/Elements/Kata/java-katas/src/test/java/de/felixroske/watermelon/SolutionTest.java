package de.felixroske.watermelon;

// TODO: Replace examples and use TDD development by writing your own tests

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Kata {
    public static boolean divide(int number) {
        return false;
    }
}

public class SolutionTest {
    @Test
    public void basicTests() {
        assertTrue(Kata.divide(4));
        assertFalse(Kata.divide(2));
        assertFalse(Kata.divide(5));
        assertTrue(Kata.divide(88));
        assertTrue(Kata.divide(100));
        assertFalse(Kata.divide(67));
        assertTrue(Kata.divide(90));
        assertTrue(Kata.divide(10));
        assertFalse(Kata.divide(99));
        assertTrue(Kata.divide(32));
    }
}
