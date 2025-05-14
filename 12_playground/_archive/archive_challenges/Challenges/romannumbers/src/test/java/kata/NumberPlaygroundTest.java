package kata;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class NumberPlaygroundTest {

    @Test
    void testIsBinaryNumber_true() {
        boolean result = NumberPlayground.isBinaryNumber("10101");
        assertThat(result, is(true));
    }

    @Test
    void testIsBinaryNumber_false() {
        boolean result = NumberPlayground.isBinaryNumber("102");
        assertThat(result, is(false));
    }

    @Test
    void testBinaryToDecimal() {
        int result = NumberPlayground.binaryToDecimal("111");
        assertThat(result, is(7));
    }

    @ParameterizedTest
    @CsvSource({"AB,171",
            "A1,161"})
    void testHexToDecimal(String hexValue, int expected) {
        int result = NumberPlayground.hexToDecimal(hexValue);
        assertThat(result, is(expected));
    }
}
