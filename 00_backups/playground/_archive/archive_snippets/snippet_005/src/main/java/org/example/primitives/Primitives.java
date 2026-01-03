package org.example.primitives;

public class Primitives {

    public static void main(String[] args) {
        System.out.println("Java Basics");
        primitives();
    }

    public static void primitives() {
        // The ones you will use the most often:
        boolean myBooleanValue = true; // or false size is not defined
        char myCharValue = 'A';  // 16 Bit (unsigned)
        short myShortValue = 1; // 16 Bit (signed)
        byte myByteValue = 42; // 8 Bit
        int myIntValue = 5; // 32 Bit
        long myLongValue = 42L; // 64 Bit

        float myFloatValue = 0.1234F; // 32 Bit You MUST mark the literal with F here
        double myDoubleValue = 0.1234; // 64 Bit Because it is a double by default

        // There are no unsigned data types as in C/C++

    }
}
