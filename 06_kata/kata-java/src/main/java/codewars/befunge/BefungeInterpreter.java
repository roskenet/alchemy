package codewars.befunge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// https://www.codewars.com/kata/526c7b931666d07889000a3c/train/java

public class BefungeInterpreter {

    public String interpret(String code) {
        return "";
    }

    @Test
    public void tests() {
        assertEquals(
                "123456789",
                new BefungeInterpreter().interpret(">987v>.v\nv456<  :\n>321 ^ _@"));

    }
}
