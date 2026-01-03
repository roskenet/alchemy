package de.felixroske.findodd;

import java.util.HashMap;

public class FindOdd {
    public static int findIt(int[] a) {
        int theOdd = 0;
        var map = new HashMap<Integer, Integer>();

        for (Integer currentInt : a) {
            int occurence = 0;
            if (map.get(currentInt) != null) {
              occurence = map.get(currentInt);
            }
            map.put(currentInt, ++occurence);
        }

        for (Integer key: map.keySet()) {
           if (map.get(key) %2 != 0) {
               theOdd = key;
           }
        }
        return theOdd;
    }
}

/*
public class FindOdd {
  public static int findIt(int[] A) {
    int xor = 0;
    for (int i = 0; i < A.length; i++) {
      xor ^= A[i];
    }
    return xor;
  }
}
 */

/*
public class FindOdd {
  public static int findIt(int[] arr) {
    return stream(arr).reduce(0, (x, y) -> x ^ y);
  }
}
 */