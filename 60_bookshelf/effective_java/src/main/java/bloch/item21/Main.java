package bloch.item21;
// Design interfaces for posterity

// example for default methods:
// removeIf:

import java.util.Arrays;
import java.util.List;

public class Main {

    static void main() {

        List<String> artists = Arrays.asList("Amy Winehouse", "Elvis Presley", "Paul Young");
        boolean removed = artists.removeIf(s -> s.startsWith("A"));

        System.out.println(removed);

    }
}
