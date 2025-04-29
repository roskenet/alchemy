package de.roskenet;

import org.assertj.core.util.Streams;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class isogram {

    public static boolean isIsogram(String str) {


        return str.length() == str.toLowerCase().chars().distinct().count();

//        Map<Character, Integer> theMap =  new HashMap<>();
//
//        for (char c : str.toLowerCase().toCharArray()) {
//            theMap.put(c, theMap.getOrDefault(c, 0) + 1);
//        }
//
//        for (Map.Entry<Character, Integer> entry : theMap.entrySet()) {
//            if (entry.getValue() > 1)
//                return false;
//        }
//
//        return true;
    }

    @Test
    public void FixedTests() {
        assertEquals(true, isogram.isIsogram("Dermatoglyphics"));
        assertEquals(true, isogram.isIsogram("isogram"));
        assertEquals(false, isogram.isIsogram("moose"));
        assertEquals(false, isogram.isIsogram("isIsogram"));
        assertEquals(false, isogram.isIsogram("aba"));
        assertEquals(false, isogram.isIsogram("moOse"));
        assertEquals(true, isogram.isIsogram("thumbscrewjapingly"));
        assertEquals(true, isogram.isIsogram(""));
    }
}
