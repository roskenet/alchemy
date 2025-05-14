package de.roskenet.kata;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class PrimeChecker {

    @ParameterizedTest
    @CsvSource({"42, false", "3, true", "11, true", "102345, false"})
    void testPrimeChecker(int number, boolean expectedResult) {
        boolean result = PrimeChecker.isPrime(number);

        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testPrimeCheckerPreCondition() {
       assertThatThrownBy(() -> PrimeChecker.isPrime(0)).isInstanceOf(AssertionError.class);
    }

    private static boolean isPrime(int number) {
        if(number < 1)
            throw new AssertionError(String.format("Input [%d] is < 0", number));

        for (int x=2; x < number/2; x++) {
            if(number % x == 0) {
                return false;
            }
        }
        return true;
    }

}
