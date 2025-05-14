package de.zalando.workshop;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.jupiter.api.Test;

class OddTesterTest {

    @Test
    void testOddTester_one() {
        assertThat(OddTester.isOdd(1), is(true));

    }

    @Test
    void testOddTester_two() {
        assertThat(OddTester.isOdd(2), is(false));
    }

    @Test
    void testOddTester_zero() throws Exception {
        assertThat(OddTester.isOdd(0), is(false));

    }

    @Test
    void testOddTester_minusone() throws Exception {
        assertThat(OddTester.isOdd(-1), is(true));

    }

    @Test
    void testOddTester_minustwo() throws Exception {
        assertThat(OddTester.isOdd(-2), is(false));

    }
    
    @Test
    void testOddTester_minusthree() throws Exception {
        assertThat(OddTester.isOdd(-3), is(true));
    }
    
    @Test
    void testOddTester_minusfour() throws Exception {
        assertThat(OddTester.isOdd(-4), is(false));
    }
}
