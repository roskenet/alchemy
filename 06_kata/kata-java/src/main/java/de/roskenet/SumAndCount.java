package de.roskenet;

//Find the number as well
// as the sum of natural numbers,
// which are divisible by 2 or 7 up
// to a given maximum value (exclusive)
// and output it to the console.
// Write method void calcSumAndCountAllNumbersDivBy_2_Or_7(int).
// Extend it so that it returns the two values instead of performing the console output.

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

record SumCount(long sum, long count) {}

public class SumAndCount {

    public SumCount calcSumAndCountAllNumbersDivBy_2_Or_7(int max) {

        var count = IntStream.range(1, max)
                .filter(it -> it % 2 == 0 || it % 7 == 0)
                .count();
        var sum = IntStream.range(1, max)
                .filter(it -> it % 2 == 0 || it % 7 == 0)
                .sum();
        // TODO: Do it in one step!

        return new SumCount(sum, count);
    }


    @Test
    public void testSumAndCountAllNumbersDivBy_2_Or_7() {
       assertThat(calcSumAndCountAllNumbersDivBy_2_Or_7(15).count()).isEqualTo(8);
       assertThat(calcSumAndCountAllNumbersDivBy_2_Or_7(15).sum()).isEqualTo(63);
    }

}
