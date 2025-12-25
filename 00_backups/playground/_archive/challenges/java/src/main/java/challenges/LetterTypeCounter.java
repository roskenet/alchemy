package challenges;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterTypeCounter {

    public static Map<String, Integer> count(String inputString) {
        var resultMap = new HashMap<String, Integer>();

        String type = null;

        for (char c : inputString.toCharArray()) {

            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                type = "VOWELS";
            }
            else {
                type = "CONSONANTS";
            }

            resultMap.compute(type, (k, v) -> (v == null) ? 1 : v+1 );
        }

        return resultMap;
    }
}
