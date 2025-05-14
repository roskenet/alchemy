import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JavaSandboxTest {

    @Test
    @Disabled
    void testPostAndPreIncrement() {
        int a = 2;

        int result = ++a + a++ + ++a;

        assertThat(result).isEqualTo(0);
    }

    @Test
    void testIteratorForArray() {
        String[] stringArray = {"Rubidium", "Carbon", "Oxygen"};

        stringArray.getClass();

        for (String a : stringArray) {
            System.out.println(String.format("Element is: %s", a));
        }
    }
}

