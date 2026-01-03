package challenges;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

// Checking whether a string contains only digits
// Write a program that checks whether the given string contains only digits.
public class Challenge004Test {

    @Test
    void testDigitTester_true() {
        var input = "01234567";

        boolean result = DigitTester.test(input);

        assertThat(result).isTrue();
    }

    @Test
    void testDigitTester_false() {
        var input = "0123d4567";

        boolean result = DigitTester.test(input);

        assertThat(result).isFalse();
    }
}
