package de.roskenet;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class PerfectNumbers {

    public static boolean isPerfectNumber(int candidate) {
        int sum = IntStream.rangeClosed(1, candidate/2)
                .filter(i -> candidate % i == 0)
                .sum();
        return sum == candidate;
    }

    @ParameterizedTest
    @CsvSource({
            "6, true",
            "28, true",
            "496, true",
            "8128, true",
            "12, false",
            "10, false",
            "15, false"
    })
    void testIsVollkommeneZahl(int zahl, boolean result) {
        assertThat(isPerfectNumber(zahl)).isEqualTo(result);
    }
}
