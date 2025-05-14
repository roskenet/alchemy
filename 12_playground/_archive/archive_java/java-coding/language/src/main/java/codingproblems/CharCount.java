package codingproblems;

import java.util.Map;
import java.util.stream.Collectors;

public class CharCount
{

    public static Map<Character, Long> countLetters(String input) {

        return input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        c -> c, Collectors.counting()
                ));
    }
}
