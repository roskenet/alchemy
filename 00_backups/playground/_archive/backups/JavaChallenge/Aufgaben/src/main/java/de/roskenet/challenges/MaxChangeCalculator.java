package de.roskenet.challenges;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class MaxChangeCalculator {

    public static int calcMaxPossibleChange(int[] values) {
        Set<Integer> possibleValues = new HashSet<>();

        // To be sure: We sort the Array:
//        Arrays.sort(values);

        for (int idx_1 = 0; idx_1 < values.length; idx_1++) {
            int n1 = values[idx_1];
            for (int idx_2 = idx_1 + 1; idx_2 < values.length; idx_2++) {
                int possibleValue =  n1 + values[idx_2];
            }
        }

        return 1;
    }

}

class MaxChangeCalculatorTest {

    @Test
    void testForMaximum_1() {
        int[] values = {1};
        assertThat(MaxChangeCalculator.calcMaxPossibleChange(values), is(1));
    }

    @Test
    void testForMaximum_2() {
        int[] values = {1, 1};
        assertThat(MaxChangeCalculator.calcMaxPossibleChange(values), is(2));
    }

    @Test
    void testForMaximum_3() {
        int[] values = {1, 5};
        assertThat(MaxChangeCalculator.calcMaxPossibleChange(values), is(1));
    }

    @Test
    void testForMaximum_4() {
        int[] values = {1, 2, 4};
        assertThat(MaxChangeCalculator.calcMaxPossibleChange(values), is(7));
    }

    @Test
    void testForMaximum_5() {
        int[] values = {1, 2, 3, 7};
        assertThat(MaxChangeCalculator.calcMaxPossibleChange(values), is(13));
    }

    @Test
    void testForMaximum_6() {
        int[] values = {1, 1, 1, 1, 5, 10, 20, 50};
        assertThat(MaxChangeCalculator.calcMaxPossibleChange(values), is(39));
    }
}
