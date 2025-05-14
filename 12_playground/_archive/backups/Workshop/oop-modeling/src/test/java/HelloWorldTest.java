import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloWorldTest {

    @Test
    void testDoSomething() {
        final String amazingString = "MyAmazingString";

        final String result = HelloWorld.doSomething(amazingString);

        assertThat(result).isEqualTo("MYAMAZINGSTRING");
    }

}
