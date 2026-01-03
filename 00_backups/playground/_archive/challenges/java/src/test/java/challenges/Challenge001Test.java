package challenges;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

// Java Coding Problems:
// Counting duplicate characters
// Write a program that counts duplicate characters from a given string.
public class Challenge001Test {
    @Test
    public void shouldAnswerWithTrue() {
        var result = CharCounter.count("Mississippi").get('s');
        assertThat(result).isEqualTo(4);
    }
}
