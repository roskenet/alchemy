package de.roskenet;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Checksum {

    public static int calcChecksum(String input) {

        input.chars().map(c -> c - '0');


        return 0;
    }

    @Test
    public void test() {
        assertThat(calcChecksum("11111")).isEqualTo(5);
    }

}
