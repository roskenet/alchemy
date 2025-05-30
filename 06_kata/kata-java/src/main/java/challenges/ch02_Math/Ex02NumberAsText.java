package challenges.ch02_Math;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Ex02NumberAsText {

    private String numberAsText(int number) {
        ArrayList<String> words = new ArrayList<>(Arrays.asList("ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"));
        String result = "";

        while (number > 0) {
            result = words.get(number % words.size()) + " " + result;
            number /= 10;
        }

        return result.trim();
    }

    // recursively:

    private String numberAsTextRecursive(int number) {
        ArrayList<String> words = new ArrayList<>(Arrays.asList("ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"));

        if (number < 10) {
            return  words.get(number % 10);
        }

        return numberAsTextRecursive(number / 10) + " " + words.get(number % 10);
    }

    @ParameterizedTest
    @CsvSource({
            "7, SEVEN",
            "42, FOUR TWO",
            "24680, TWO FOUR SIX EIGHT ZERO",
            "13579, ONE THREE FIVE SEVEN NINE"
    })
    void testNumberAsText(int number, String result) {
        assertThat(numberAsTextRecursive(number)).isEqualTo(result);
    }

}
