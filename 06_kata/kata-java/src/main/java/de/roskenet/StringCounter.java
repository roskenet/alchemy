package de.roskenet;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCounter {

    public static int countLongestSubstring(String s) {

        boolean hasUppercase = false;
        int longestSubstring = 0;
        int currentCounter=0;

        for (int i = 0; i < s.length(); i++) {
            if(Character.isUpperCase(s.charAt(i))) {
               hasUppercase = true;
               currentCounter++;
               continue;
            }
            if(Character.isDigit(s.charAt(i))) {
                if(hasUppercase && currentCounter > longestSubstring) {
                    longestSubstring = currentCounter;
                }
                currentCounter = 0;
                hasUppercase = false;
            }
            currentCounter++;
        }

        return longestSubstring;
    }

    @Test
    void countLongestSubstringTest() {
        assertThat(countLongestSubstring("abcabcbb")).isEqualTo(0);
        assertThat(countLongestSubstring("abcAbc0bb")).isEqualTo(6);
        assertThat(countLongestSubstring("AA4b")).isEqualTo(2);
    }
}
