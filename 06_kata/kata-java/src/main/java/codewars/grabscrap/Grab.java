package codewars.grabscrap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Grab {

    public static List<String> grabscrab(String s, List<String> words) {

        List<String> list = words.stream().filter(w -> alphabetize(s).equals(alphabetize(w))).toList();

        return list;
    }

    private static String alphabetize(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }

    static private String[][][] DATA = {
            //    anagram       words_as_array                       expected_as_array
            {{"trisf"}, {"first"}, {"first"}},
            {{"oob"}, {"bob", "baobab"}, {}},
            {{"ainstuomn"}, {"mountains", "hills", "mesa"}, {"mountains"}},
            {{"oolp"}, {"donkey", "pool", "horse", "loop"}, {"pool", "loop"}},
            {{"ortsp"}, {"sport", "parrot", "ports", "matey"}, {"sport", "ports"}},
            {{"ourf"}, {"one", "two", "three"}, {}}
    };

    @Test
    void fixed_tests() {
        for (String[][] data : DATA) {
            var anagram = data[0][0];
            var words = Arrays.stream(data[1]).collect(Collectors.toList());
            var exp = Arrays.stream(data[2]).collect(Collectors.toList());
            var msg = String.format("Testing \"%s\" against %s", anagram, words);
            var actual = Grab.grabscrab(anagram, words);
            assertEquals(exp, actual, msg);
        }
    }

}
