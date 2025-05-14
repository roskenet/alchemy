package de.felixroske.charcount;

import java.util.HashMap;
import java.util.Map;

public final class CharacterCounter {

    private CharacterCounter() {
       // intentionally left empty

        var characterIntegerHashMap = new HashMap<Character, Integer>();

    }

    public static Map<Character, Integer> countCharacters(final String input) {

        Map<Character, Integer> map = new HashMap<>();

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
