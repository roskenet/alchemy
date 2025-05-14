package de.roskenet.puzzles.part01;

import java.util.HashMap;
import java.util.Map;

public class CharacterCounter {

    public static Map<Character, Integer> doCount(String input) {

        var hashMap = new HashMap<Character, Integer>();

        for(Character character : input.toCharArray()) {
           var count = hashMap.get(character);

           if(count == null) {
               count = Integer.valueOf(0);
           }

           hashMap.put(character, ++count);
        }

        return hashMap;
    }

}
