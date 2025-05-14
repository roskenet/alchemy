package optionals;

import java.util.Optional;

public class Basic {
    public static void main(String[] args) {
        Optional<Boolean> mightBeThere = maybeValueFor(42);
        mightBeThere.ifPresentOrElse(System.out::println, System.out::println);
    }
    private static Optional<Boolean> maybeValueFor(int i) {
       return i % 2 == 0 ? Optional.of(Boolean.TRUE) : Optional.empty();
    }
}
