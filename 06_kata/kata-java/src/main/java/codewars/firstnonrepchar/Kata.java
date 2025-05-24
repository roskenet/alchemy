package codewars.firstnonrepchar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Kata {
    public static String firstNonRepeatingLetter(String s) {

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
          Character c = Character.toLowerCase(s.charAt(i));
          if (map.containsKey(c)) {
            map.put(c, map.get(c) + 1);
          } else {
            map.put(c, 1);
          }
        }

      for (int i = 0; i < s.length(); i++) {
        Character c = Character.toLowerCase(s.charAt(i));
        if (map.get(c) < 2) {
           return s.substring(i, i + 1);
        }
      }

        return "";
    }

    @Test
    @DisplayName("Sample tests")
    void sampleTests() {
        assertEquals("a", Kata.firstNonRepeatingLetter("a"), "For input \"a\"");
        assertEquals("t", Kata.firstNonRepeatingLetter("streSS"), "For input \"streSS\"");
        assertEquals("-", Kata.firstNonRepeatingLetter("moon-men"), "For input \"moon-men\"");
        assertEquals("", Kata.firstNonRepeatingLetter("moonmoon"), "For input \"moonmoon\"");
    }
}
