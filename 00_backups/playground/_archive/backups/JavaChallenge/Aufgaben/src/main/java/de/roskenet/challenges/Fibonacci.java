package de.roskenet.challenges;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

/*
The classic Fibonacci-sequence recursively
 */
public class Fibonacci {

    public static int fibonacci(int n) {
        if (n <= 2) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}

class FibonacciTest {

    @Test
    void testFibonacci_1() {
        assertThat(Fibonacci.fibonacci(1), is(1));
    }

    @Test
    void testFibonacci_2() {
        assertThat(Fibonacci.fibonacci(2), is(1));
    }

    @Test
    void testFibonacci_3() {
        assertThat(Fibonacci.fibonacci(3), is(2));
    }

    @Test
    void testFibonacci_4() {
        assertThat(Fibonacci.fibonacci(4), is(3));
    }

    @Test
    void testFibonacci_5() {
        assertThat(Fibonacci.fibonacci(5), is(5));
    }

    @Test
    void testFibonacci_6() {
        assertThat(Fibonacci.fibonacci(6), is(8));
    }

    @Test
    void testFibonacci_7() {
        assertThat(Fibonacci.fibonacci(7), is(13));
    }

    @Test
    void testFibonacci_8() {
        assertThat(Fibonacci.fibonacci(8), is(21));
    }
}
