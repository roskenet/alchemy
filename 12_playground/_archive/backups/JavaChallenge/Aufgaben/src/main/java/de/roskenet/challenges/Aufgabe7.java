package de.roskenet.challenges;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.regex.Pattern;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class Aufgabe7 {
    public static int fromRomanNumber(final String input) {

        // Was gibt es fuer Tokens?
        //
        // MMM MM M
        // CCC CC C
        // L
        // XXX XX X IX
        // V IV
        // III II I

        Pattern pattern = Pattern.compile("I$");

        return 0;
    }
}

class Aufgabe7Test {
    @ParameterizedTest
    @CsvSource({"XVII, 17",
                "CDXLIV, 444",
                "MCMLXXI, 1971",
                "MMXX, 2020"})
    void testFromRomanNumber(String input, int expected) throws Exception {
        assertThat(Aufgabe7.fromRomanNumber(input), is(expected));
    }
}