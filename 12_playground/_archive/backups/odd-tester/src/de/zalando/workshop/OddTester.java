package de.zalando.workshop;

public class OddTester {

    public static boolean isOdd(int i) {
        
        // First version:
//        return i % 2 == 1;
        // Second version:
//        return i % 2 != 0;
        // Smart version:
       return (i & 1) != 0;
    }
}
