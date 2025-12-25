import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MyClass {

    public static Map<Character, Integer> countChars(String input) {

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : input.toUpperCase().toCharArray()) {
            Integer occurrences = map.get(c);
            if(occurrences == null) {
                occurrences = Integer.valueOf(0);
            }
            map.put(c, ++occurrences); // Todo: Difference to occurrence++
        }

        return map;
    }

}
