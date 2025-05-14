package challenges;

import java.util.HashMap;
import java.util.Map;

public class CharCounter {
    private CharCounter() {}

    public static Map<Character, Integer> count(String argument) {

        var charMap = new HashMap<Character, Integer>();

        argument.toLowerCase().chars().forEach(
               c -> {
                   charMap.compute((char) c, (k, v) -> (v == null) ? 1 : v+1);
               }
        );

        return charMap;
    }
}
