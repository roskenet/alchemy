package ch02_Math;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class Ex01BasicArithmetic {

    int calc(int m, int n) {
        return (m * n / 2) % 7;
    }

    @ParameterizedTest
    @CsvSource({
            "6, 7, 0",
            "3, 4, 6",
            "5, 5, 5"
    })
    void testCalc(int m, int n, int result) {
        assertThat(calc(m, n)).isEqualTo(result);
    }
}
