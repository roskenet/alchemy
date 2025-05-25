package unsorted;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// Erstelle alle substrings
public class SubStrings {

    public static Map<String, Integer> subStringsOf(String str) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int x = 0; x < str.length(); x++) {
          for (int y = x+1; y <= str.length(); y++) {
             var substr = str.substring(x, y);
             map.put(substr, map.getOrDefault(substr, 0) + 1);
          }
       }

       return map;
    }

    public static void main(String[] args) {
       String theTestString = "Abrakadabra";
       var subStrings = subStringsOf(theTestString);
       System.out.println(subStrings);
    }
}
