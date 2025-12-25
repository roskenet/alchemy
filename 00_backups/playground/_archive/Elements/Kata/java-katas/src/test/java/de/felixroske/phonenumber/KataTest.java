package de.felixroske.phonenumber;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Kata {
    private static String PHONE_FORMAT = "(%d%d%d) %d%d%d-%d%d%d%d";

    static String createPhoneNumber(int[] numbers) {
        var result = String.format(PHONE_FORMAT,
                numbers[0], numbers[1], numbers[2],
                numbers[3], numbers[4], numbers[5],
                numbers[6], numbers[7], numbers[8], numbers[9]);
        return result;
    }
}

public class KataTest {
    @Test
    public void shouldPass() {
        String result = Kata.createPhoneNumber(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0});
        assertThat(result).isEqualTo("(123) 456-7890");
    }
}
