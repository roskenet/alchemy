package de.roskenet.kata;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class FactorFinder {

    private static List<Integer> find(int num) {
        var list = new ArrayList<Integer>();
        list.add(1);

        for (int i=2; i<=num; i++) {
            if (num % i == 0) {
                list.add(i);
            }
        }
        return list;
    }

    @ParameterizedTest
    @MethodSource("generateTestCases")
    void testFactorFinder(int num, List<Integer> expectedList) {
        List<Integer> result = FactorFinder.find(num);

        assertThat(result).containsExactlyInAnyOrderElementsOf(expectedList);
    }

    private static Stream<Arguments> generateTestCases() {
        return Stream.of(Arguments.of(1, List.of(1)), Arguments.of(10, List.of(1,2,5,10)));
    }
}
