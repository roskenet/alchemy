package de.roskenet.kata.ch1;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class Challenge1aTest {

    @ParameterizedTest(name = "#{index} - {0} * {1} / 2 % 7 should be {2}")
    @CsvSource({
            "6, 7,      0",
            "3, 4,      6",
            "5, 5,      5"
    })
    public void testCalc(int m, int n, int result) {
        assertThat(Challenge1a.calc(m,n), is(result));
    }
}
