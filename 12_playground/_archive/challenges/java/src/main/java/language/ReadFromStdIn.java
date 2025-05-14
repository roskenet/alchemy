package language;

import java.util.Scanner;

public class ReadFromStdIn {
    public static void main(String[] args) {
        System.out.print("Hi! Please enter your name: ");

        var scanner = new Scanner(System.in);
        var name = scanner.nextLine();

        System.out.println(String.format("Hello %s!", name));
    }
}
