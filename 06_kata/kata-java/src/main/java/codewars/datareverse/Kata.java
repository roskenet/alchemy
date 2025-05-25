package codewars.datareverse;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Kata {
    public static int[] DataReverse(int[] data) {

        int[] result = new int[data.length];
        int numOfBytes = data.length / 8;

        for (int i = 0; i < numOfBytes; i++) {
            for (int j = 0; j < 8 ; j++) {
                result[(numOfBytes-i-1) * 8 + j] = data[i * 8 + j];
            }
        }

        return result;
    }


    private static void doTest(int[] input, int[] expected) {
        String message = String.format("for input = %s\n", Arrays.toString(input));
        int[] actual = Kata.DataReverse(input);
        assertArrayEquals(expected, actual, message);
    }

    @Test
    public void fixedTests() {
        doTest(
                new int[]{0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0},
                new int[]{1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1}
        );
        doTest(
                new int[]{1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                new int[]{1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0}
        );
        doTest(new int[0], new int[0]);
        doTest(new int[]{1, 0, 1, 0, 0, 1, 0, 1}, new int[]{1, 0, 1, 0, 0, 1, 0, 1});
    }
}

