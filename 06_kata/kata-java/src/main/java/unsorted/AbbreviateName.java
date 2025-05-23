package unsorted;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AbbreviateName {

    private static String abbrevName(String name) {
        return Arrays.stream(name.split(" "))
                .map(it -> (it.charAt(0) + "").toUpperCase())
                .collect(Collectors.joining("."));
    }

    @Test
    public void testFixed() {
        assertEquals("S.H", abbrevName("Sam Harris"));
        assertEquals("P.F", abbrevName("Patrick Feenan"));
        assertEquals("E.C", abbrevName("Evan Cole"));
        assertEquals("P.F", abbrevName("P Favuzzi"));
        assertEquals("D.M", abbrevName("David Mendieta"));
    }
}
