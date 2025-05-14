package de.roskenet.kata;

import org.junit.jupiter.api.Test;

public class NumConverter {

    @Test
    void testNumberConversion() {
       String intStr = "42";
       String longStr = "35673761000";
       String floatStr = "1.12345";
       String doubleStr = "1.12345678912345";

       // This is using unboxing:
       int myInteger = Integer.valueOf(intStr);
       long myLong = Long.valueOf(longStr);
       float myFloat = Float.valueOf(floatStr);
       double myDouble = Double.valueOf(doubleStr);

       // To convert to primitive types directly:

        var myPrimitiveInt = Integer.parseInt(intStr);
    }
}
