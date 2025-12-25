package challenges;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

// Java Problems
// Finding the first non-repeated character
// Write a program that returns the first non-repeated character from a given string.
public class Challenge002Test {
    @Test
    void testFirstNonRepeater() {
        char c = FirstNonRepeater.find("mmmmmmmmui");

        assertThat(c).isEqualTo('u');
    }
}
