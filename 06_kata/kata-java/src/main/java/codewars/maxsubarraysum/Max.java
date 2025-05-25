package codewars.maxsubarraysum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//
// https://www.codewars.com/kata/54521e9ec8e60bc4de000d6c/train/java
//
public class Max {
    private static int sequence(int[] ints) {
        // store a max variable
        int max = 0;

        return 0;
    }

    @Test
    public void testEmptyArray() throws Exception {
        assertEquals(0, Max.sequence(new int[]{}));
    }

    @Test
    public void testExampleArray() throws Exception {
        assertEquals(6, Max.sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
