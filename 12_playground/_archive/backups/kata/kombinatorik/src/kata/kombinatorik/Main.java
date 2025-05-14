package kata.kombinatorik;

import java.util.ArrayList;

public class Main {

    // Berechnen Sie alle Kombinationen der Werte a, b und c (jeweils ab 1 und kleiner 100), fuer
    // die folgende Formel gilt:
    // a^2 + b^b = c^2
    public static void main(String[] args) {

        for (int a=1; a < 100; a++) {
           for (int b=1; b < 100; b++) {
               for (int c=1; c < 100; c++) {
                   if (a*a + b*b == c*c) {
                       System.out.printf("%d^2 + %d^2 = %d^2%n", a, b, c);
                   }
               }
           }
        }

    }
}
