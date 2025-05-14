package de.zalando.workshop;

import java.util.Arrays;

public class Text {

    private final char[] thisChars;

    public Text(String initalString) {
        thisChars = initalString.trim().toLowerCase()
                .toCharArray();
        Arrays.sort(thisChars);
    }

    public boolean isAnagramTo(String other) {
        char[] otherChars = other.trim().toLowerCase()
                .toCharArray();
        Arrays.sort(otherChars);

        return Arrays.equals(thisChars, otherChars);
    }
}
