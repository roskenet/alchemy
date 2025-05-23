package unsorted;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReversedStrings {

    public static String solution(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    @Test
    public void sampleTests() {
      assertEquals("dlrow", ReversedStrings.solution("world"));
    }
}