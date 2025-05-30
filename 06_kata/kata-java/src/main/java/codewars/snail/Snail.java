package codewars.snail;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static java.util.stream.Collectors.joining;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Snail {

    public static int[] snail(int[][] array) {
        int currDirection = 0; // right down left up
        int[] result = new int[array.length*array.length];
        int currX = 0;
        int currY = 0;

        for (int field = 0; field < array.length * array.length; field++ ) {
           result[field] = array[currY][currX];

        }

        return new int[0];
    }

    @Test
    public void SnailTest1() {
        int[][] array
                = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        int[] r = {1, 2, 3, 6, 9, 8, 7, 4, 5};
        test(array, r);
    }

    public String int2dToString(int[][] a) {
        return Arrays.stream(a).map(row -> Arrays.toString(row)).collect(joining("\n"));
    }

    public void test(int[][] array, int[] result) {
        String text = int2dToString(array) + " should be sorted to " + Arrays.toString(result);
        System.out.println(text);
        assertArrayEquals(result, Snail.snail(array));
    }


}
