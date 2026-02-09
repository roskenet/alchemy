package felix.demo.streams;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.IntSupplier;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class SupplierDemo {
    public static void main(String[] args) {
        Supplier<Integer> supplier = () -> ThreadLocalRandom.current().nextInt(1, 101);

        Stream<Integer> randomIntegers = Stream.generate(supplier);

        Map<Integer, Long> integerCounts = randomIntegers.limit(10000000).collect(groupingBy(e -> e, counting()));

        integerCounts.forEach((k, v) -> System.out.println(k + ": " + v));

    }
}
