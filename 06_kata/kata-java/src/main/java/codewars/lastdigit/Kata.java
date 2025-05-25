package codewars.lastdigit;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Kata {

    // This is more a math problem than a programming task
    private static int lastDigit(BigInteger n1, BigInteger n2) {

        int initDigit = n1.mod(new BigInteger("10")).intValue();
        int expDigit = n2.mod(new BigInteger("10")).intValue();
        int result = 0;

        for (int i = initDigit; i <= expDigit; i++) {
           // TODO...
        }

        return result;
    }

    @Test
    public void testSomething() {
        assertEquals(8, Kata.lastDigit(new BigInteger("2"), new BigInteger("7")));
        assertEquals(4, Kata.lastDigit(new BigInteger("4"), new BigInteger("1")));
        assertEquals(6, Kata.lastDigit(new BigInteger("4"), new BigInteger("2")));
        assertEquals(9, Kata.lastDigit(new BigInteger("9"), new BigInteger("7")));
    }

}
