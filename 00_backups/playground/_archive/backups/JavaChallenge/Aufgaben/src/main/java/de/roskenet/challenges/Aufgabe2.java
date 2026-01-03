package de.roskenet.challenges;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

public class Aufgabe2 {

    static String numberAsText(final int number) {
        return accumulate(number, "").trim();
    }

    static private String accumulate(final int number, final String accu) {
        if(number < 10) {
            return addDigitAsText(number) + " " + accu;
        }

        return accumulate(number / 10, addDigitAsText(number % 10) + " " + accu);
    }

    static private String addDigitAsText(final int number) {
       switch (number) {
           case 0:
               return "ZERO";
           case 1:
               return "ONE";
           case 2:
               return "TWO";
           case 3:
               return "THREE";
           case 4:
               return "FOUR";
           case 5:
               return "FIVE";
           case 6:
               return "SIX";
           case 7:
               return "SEVEN";
           case 8:
               return "EIGHT";
           case 9:
               return "NINE";
           default:
               throw new IllegalArgumentException("Illegal digit: " + number);
       }
    }
}

class Aufgabe2Test {

    @Test
    void testNumberAsText() throws Exception {
        assertThat(Aufgabe2.numberAsText(210), is("TWO ONE ZERO"));
    }

}

