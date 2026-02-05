package bloch.item59;
// Know and use the libraries
// Example:
// the random number generator of choice is now ThreadLocalRandom

//  Be familiar with
//  * java.lang
//  * java.util
//  * java.io

import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    static void main(String[] args) throws Exception {
//        for (int x = 0; x < 10; x++) {
//            int i = ThreadLocalRandom.current().nextInt(3);
//
//            System.out.println("Ich habe ein " + i + " erzeugt!");
//        }
        // Another example for an cool library feature:

//        try (InputStream in = new URL(args[0]).openStream()) {
        try (InputStream in = new URL("http://www.felix-roske.de/").openStream()) {
            in.transferTo(System.out);
        }
    }
}
