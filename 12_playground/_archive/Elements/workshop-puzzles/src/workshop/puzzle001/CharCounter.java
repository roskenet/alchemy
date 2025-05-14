package workshop.puzzle001;

import java.util.HashMap;
import java.util.Map;

// TODO:
// Write a program that counts characters in a given string.
class CharCounter {

    public static Map<Character, Integer> countCharacters(String str) {

        Map<Character, Integer> result = new HashMap<>();

        // or use for(char ch: str.toCharArray()) { ... }
        for (int i = 0; i < str.length(); i++) {
          char ch = str.charAt(i); 
          result.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
        }

        return result;
      }
}
