package de.roskenet.kata;

import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class PlayWithStreams {

    public static void main(String[] args) {

        var random = new Random();

        Stream<Boolean> booleanStream = Stream.generate(random::nextBoolean);

        Map<Boolean, Long> resultMap = booleanStream
                .limit(1000)
                .collect(
                        Collectors.groupingByConcurrent(b -> b, Collectors.counting())
                );

        System.out.println(String.format("Wahr: %d", resultMap.get(TRUE)));
        System.out.println(String.format("Unwahr: %d", resultMap.get(FALSE)));
    }

}
