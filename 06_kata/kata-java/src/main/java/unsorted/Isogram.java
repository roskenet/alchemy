package unsorted;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Isogram {

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
        assertEquals(true, Isogram.isIsogram("Dermatoglyphics"));
        assertEquals(true, Isogram.isIsogram("isogram"));
        assertEquals(false, Isogram.isIsogram("moose"));
        assertEquals(false, Isogram.isIsogram("isIsogram"));
        assertEquals(false, Isogram.isIsogram("aba"));
        assertEquals(false, Isogram.isIsogram("moOse"));
        assertEquals(true, Isogram.isIsogram("thumbscrewjapingly"));
        assertEquals(true, Isogram.isIsogram(""));
    }
}
