package de.roskenet.reference;

import java.util.Arrays;

public class ReferenceSemanticsExample {
    private static void doSomething(String[] strings) {
        strings[0] = "One";
        strings[1] = "Two";
        strings[2] = "Three";

//        strings = new String[] {"NewOne", "NewTwo"};
    }

    public static void main(String[] args) {
        final String[] strings = {"OriginalOne", "OriginalTwo", "OriginalThree"};

        doSomething(strings);

        System.out.println(Arrays.toString(strings));
    }
}
