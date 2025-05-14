package language;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMap {

    public static void main(String[] args) {
        Stream.of(1, 2, 3, 4).map(x -> x * 2).collect(Collectors.toList());

        Stream.of(1, 2, 3, 4)
                .map(x -> Stream.of(-x, x, x + 1))
                .collect(Collectors.toList());

        Stream.of(1, 2, 3, 4)
                .flatMap(x -> Stream.of(-x, x, x+1))
                .collect(Collectors.toList());
    }
}
