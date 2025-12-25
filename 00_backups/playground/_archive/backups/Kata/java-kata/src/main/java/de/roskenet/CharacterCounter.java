package de.roskenet;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CharacterCounter {

    public static long countForChar(String str, char theChar) {
        return str.chars()
                .filter(c -> c == theChar)
                .count();
    }
}

class CharacterCounterTest {

    @Test
    void test_Mississippi() {
        assertThat(CharacterCounter.countForChar("Mississippi", 's')).isEqualTo(4);
        assertThat(CharacterCounter.countForChar("Mississippi", 'p')).isEqualTo(2);
    }
}
