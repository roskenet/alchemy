package de.roskenet;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class Checksum {

    public static int calcChecksum(String input) {
        // very "streamy":
        return IntStream.range(0, input.length())
            .map(i -> (input.charAt(i) - '0') * (i + 1))
            .sum() % 10;

//        var idx = 1;
//        var sum = 0;
//
//        for(char c : input.toCharArray()) {
//           sum += Integer.valueOf(c - '0') * idx++;
//        }
//        return sum % 10;
    }

    @Test
    public void test() {
        assertThat(calcChecksum("11111")).isEqualTo(5);
        assertThat(calcChecksum("87654321")).isEqualTo(0);
    }

}
