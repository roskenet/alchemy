package flxkata;

// #1: Counting duplicate characters:
// Write a program that counts duplicate characters from a given string.

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class CharCounter {

    public static Map<Character, Long> getMap(String input) {
        return input.toLowerCase().chars().boxed()
                .collect(Collectors.groupingBy(integer -> (char) integer.intValue(), Collectors.counting()));
    }

    @Test
    public void testCharCounter() {
        String input = "Mississippi";

        Map<Character, Long> map = getMap(input);

        assertThat(map.get('m')).isEqualTo(1);
        assertThat(map.get('s')).isEqualTo(4);
    }
}



