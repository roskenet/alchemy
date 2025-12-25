package de.roskenet.challenges;

public class Aufgabe1b {

    public static void main(String[] args) {

        calcSumAndCountAllNumbersDivBy_2_Or_7(3);
        calcSumAndCountAllNumbersDivBy_2_Or_7(8);
        calcSumAndCountAllNumbersDivBy_2_Or_7(15);

    }

    public static void calcSumAndCountAllNumbersDivBy_2_Or_7(final int start) {
        int sum = 0;
        int counter = 0;

        for (int i=1; i < start; i++) {
            if (i % 2 == 0 || i % 7 == 0) {
                System.out.print(i + " ");
                sum += i;
                counter++;
            }
        }
        System.out.println("Summe: " + sum + " Anzahl: " + counter);
    }
}
