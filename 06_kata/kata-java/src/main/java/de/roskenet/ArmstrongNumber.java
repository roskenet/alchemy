package de.roskenet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

//A Narcissistic Number (or Armstrong Number)
//is a positive number which is the sum of its own digits,
//each raised to the power of the number of digits in a given base.
//In this Kata, we will restrict ourselves to decimal (base 10).
//
//For example, take 153 (3 digits), which is narcissistic:
//    1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153

public class ArmstrongNumber {

    public static boolean isNarcissistic(int number) {

        int length = String.valueOf(number).length();
        long acc = 0;

        for (int i = 0; i < length; i++) {
            var theDigit = Integer.valueOf(String.valueOf(number).substring(i, i + 1));
            acc += Math.pow(theDigit, length);
        }

        return number == acc;

    }

    @Test
    void exampleTests() {
        assertTrue(ArmstrongNumber.isNarcissistic(153), "153 is narcissistic");
        assertTrue(ArmstrongNumber.isNarcissistic(1634), "1634 is narcissistic");
        assertFalse(ArmstrongNumber.isNarcissistic(112), "112 is not narcissistic");
    }
}
