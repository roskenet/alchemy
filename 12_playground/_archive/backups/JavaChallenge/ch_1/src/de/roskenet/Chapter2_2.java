package de.roskenet;

public class Chapter2_2 {

    public static void main(String[] args) {
        System.out.println("All divisors of : ");
        showDivisors( 10);
    }

    static void showDivisors(final int number) {
        showDivisors(1, number);
    }

    static void showDivisors(final int div, final int number) {
        if((number/2) < div) {
            return;
        }

        if(number % div == 0) {
            System.out.println("Teiler: " + div);
        }

        showDivisors(div+1, number);
    }

}
