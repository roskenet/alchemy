package de.roskenet.kata;

import java.util.Scanner;

public class Dreieck {
    public static void main(String[] args) {
//        System.out.print("Please enter the base: ");
//        var base = new Scanner(System.in).nextInt();
//        if (base%2 != 1)
//            throw new IllegalArgumentException("Base must be odd!");

        var base = 13;

        System.out.println("*".repeat(base));

        for(int line=1; line < base/2; line++) {
           StringBuilder sb = new StringBuilder();
            var length = base - line * 2;

            sb.append(" ".repeat(line));
            sb.append('*');
            sb.append(" ".repeat(length - 2));
            sb.append('*');
            System.out.println(sb);
        }

        System.out.print(" ".repeat(base / 2));
        System.out.println('*');
    }
}
