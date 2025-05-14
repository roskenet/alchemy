package de.roskenet.puzzles.part01;


import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/*
Task:
Write a method that counts the characters in a string and stores them in a suitable data structure.
 */
public class CharacterCounterTest {

    @Test
    void testDoCount() {
        final String input = "Mississippi";

        var characterCount = CharacterCounter.doCount(input);

        assertThat(characterCount.get('i')).isEqualTo(4);
    }

}
