package codewars.numtoarray;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Kata {
  public static int[] digitize(long n) {
      int[] result = new int[0];
      do {
          result = Arrays.copyOf(result, result.length + 1 );
          result[result.length - 1] = (int) (n % 10);
          n /= 10;
      } while (n > 0);
      return result;
  }
}

class DigitizeTests {
  @Test
  public void sampleTests() {
    assertArrayEquals(new int[] {1,3,2,5,3}, Kata.digitize(35231));
    assertArrayEquals(new int[] {0}, Kata.digitize(0));
    assertArrayEquals(new int[] {7,5,3,2,8,5,3,2}, Kata.digitize(23582357));
    assertArrayEquals(new int[] {8,3,7,4,6,7,4,8,9}, Kata.digitize(984764738));
    assertArrayEquals(new int[] {0,2,9,3,9,8,2,6,7,5,4}, Kata.digitize(45762893920L));
    assertArrayEquals(new int[] {4,9,3,8,3,8,2,0,7,8,4,5}, Kata.digitize(548702838394L));
  }
}