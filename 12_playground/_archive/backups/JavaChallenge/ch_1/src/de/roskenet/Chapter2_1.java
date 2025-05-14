package de.roskenet;

public class Chapter2_1 {

    public static void main(String[] args) {
        extractLastDigit(1234);
    }

    public static void extractLastDigit(final int zahl) {

        if(zahl == 0) {
           return;
        }

        int lastDigit = zahl % 10;
        System.out.printf("Letzte Stelle: " + lastDigit + "\n");

        extractLastDigit(zahl / 10);
    }

}
