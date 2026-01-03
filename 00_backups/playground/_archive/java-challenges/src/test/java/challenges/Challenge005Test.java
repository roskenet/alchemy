package challenges;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

// Counting vowels and consonants:
// Write a program that counts the number of vowels and consonants in a given string.
// Do this for the English language, which has five vowels (a, e, i, o, and u).
public class Challenge005Test {

    @Test
    void testLetterTypeCounter_vowels() {
        var inputString = "LetterTypeCounter";

        int result = LetterTypeCounter.count(inputString).get("VOWELS");

        assertThat(result).isEqualTo(6);
    }
    @Test
    void testLetterTypeCounter_consonants() {
        var inputString = "LetterTypeCounter";

        int result = LetterTypeCounter.count(inputString).get("CONSONANTS");

        assertThat(result).isEqualTo(11);
    }
}
