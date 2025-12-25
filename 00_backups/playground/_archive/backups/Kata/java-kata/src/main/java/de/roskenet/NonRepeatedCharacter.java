package de.roskenet;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class NonRepeatedCharacter {

    public static char getFirstNonRepeatedCharacter(String inputString) {
        char currentChar = inputString.charAt(0);

        for (int idx=1; idx < inputString.length(); idx++) {
            if(inputString.charAt(idx) != currentChar) {
                return inputString.charAt(idx);
            }
        }

        return '\0';
    }
}

class NonRepeatedCharacterTest {
    @Test
    void testFirstCharacterInTheBeginning() {
        assertThat(NonRepeatedCharacter.getFirstNonRepeatedCharacter("xXabcdexX")).isEqualTo('X');
    }

    @Test
    void testFirstCharacterIsAtTheEnd() {
        assertThat(NonRepeatedCharacter.getFirstNonRepeatedCharacter("aaaaaaA")).isEqualTo('A');
    }

    @Test
    void testFirstCharacterIsInTheMiddle() {
        assertThat(NonRepeatedCharacter.getFirstNonRepeatedCharacter("xxxxXxxxx")).isEqualTo('X');
    }
}
