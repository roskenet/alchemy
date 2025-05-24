package codewars;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ArrayDiff {

    public static int[] arrayDiff(int[] a, int[] b) {
//        int[] resultArray = new int[]{};
//
//        for (int i = 0; i < b.length; i++) {
//           for (int j = 0; j < a.length; j++) {
//               if (b[i] == a[j]) {
//                   a[j] = -1;
//               }
//           }
//        }
//
//        for (int i = 0; i < a.length; i++) {
//            if (a[i] != -1) {
//                resultArray = Arrays.copyOf(resultArray, resultArray.length + 1);
//                resultArray[resultArray.length - 1] = a[i];
//            }
//        }
//
//        return resultArray;

// Best idiomatic solution is for sure:
    List<Integer> bList = Arrays.stream(b).boxed().collect(Collectors.toList());
        return Arrays.stream(a)
            .filter(x -> !bList.contains(x))
            .toArray();
    }

    @Test
    public void sampleTests() {
      assertArrayEquals(new int[] {2}, ArrayDiff.arrayDiff(new int [] {1,2}, new int[] {1}));
      assertArrayEquals(new int[] {2,2}, ArrayDiff.arrayDiff(new int [] {1,2,2}, new int[] {1}));
      assertArrayEquals(new int[] {1}, ArrayDiff.arrayDiff(new int [] {1,2,2}, new int[] {2}));
      assertArrayEquals(new int[] {1,2,2}, ArrayDiff.arrayDiff(new int [] {1,2,2}, new int[] {}));
      assertArrayEquals(new int[] {}, ArrayDiff.arrayDiff(new int [] {}, new int[] {1,2}));
    }
}
