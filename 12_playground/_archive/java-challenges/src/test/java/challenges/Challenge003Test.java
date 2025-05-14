package challenges;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

// Reversing letters and words:
// Write a program that reverses the letters of each word
// and a program that reverses the letters
// of each word and the words themselves.
public class Challenge003Test {

    @Test
    void testLetterReverser() {
        var inputString = "Reversing letters and words.";

        String result = Reverser.reverseLetters(inputString);

        assertThat(result).isEqualTo("gnisreveR srettel dna .sdrow");
    }

    @Test
    void testWordReverser() {
        var inputString = "Reversing letters and words.";

        String result = Reverser.reverseWordsAndLetters(inputString);

        assertThat(result).isEqualTo(".sdrow dna srettel gnisreveR");
    }
}
