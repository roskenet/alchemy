package de.felixroske.vowelcount;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class Vowels {
    public static int getCount(String str) {
        var characters = Arrays.asList('a', 'e', 'i', 'o', 'u');
        int vowelsCount = 0;

        for (char letter :
                str.toCharArray()) {
            if (characters.contains(letter)) {
                vowelsCount++;
            }
        }

        return vowelsCount;
    }
}

public class VowelsTest {
    @Test
    public void testCase1() {
        assertThat(Vowels.getCount("abracadabra")).isEqualTo(5);
    }

}
