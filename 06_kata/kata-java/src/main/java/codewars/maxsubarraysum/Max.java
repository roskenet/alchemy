package codewars.maxsubarraysum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//
// https://www.codewars.com/kata/54521e9ec8e60bc4de000d6c/train/java
//
public class Max {
    private static int sequence(int[] arr) {
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
           for (int j = i; j < arr.length; j++) {
              int currentRange = 0;
              boolean hasPositive = false;
              for (int k = i ; k <= j ; k++) {
                  if (arr[k] > 0) {
                      hasPositive = true;
                  }
                  currentRange += arr[k];
              }
              if (hasPositive && currentRange > max) {
                  max = currentRange;
              }
           }
        }
        return max;
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
