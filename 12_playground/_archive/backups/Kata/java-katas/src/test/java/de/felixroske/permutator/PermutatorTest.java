package de.felixroske.permutator;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class Permutator {
    public static Set<String> permuteAndStore(String str) {
        return permuteAndStore("", str);
    }

    private static Set<String> permuteAndStore(String prefix, String str) {
        Set<String> permutations = new HashSet<>();
        int n = str.length();

        if (n == 0) {
            permutations.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                permutations.addAll(permuteAndStore(prefix + str.charAt(i),
                        str.substring(i + 1, n) + str.substring(0, i)));
            }
        }
        return permutations;
    }
}

public class PermutatorTest {

    @Test
    void testPermutator_ABC() throws Exception {
        var permutations = Permutator.permuteAndStore("ABC");

        assertThat(permutations).isEqualTo(Set.of("ABC", "ACB", "BAC", "BCA", "CBA", "CAB"));
    }

}
