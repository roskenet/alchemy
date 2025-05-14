package springstuff.springconfig;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import springstuff.jugglers.Juggler;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class JugglerAppTest {

    private static Juggler testJuggler;
    private static OutputStream myOut;

    @BeforeAll
    static void setup() {
        myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));

        testJuggler = new Juggler() {
            @Override
            public String perform() {
                return "I don't juggle at all. I am only a Mock.";
            }
        };
    }

    @Test
    void testTheApp() {
        TheApp theApp = new JugglerApp(testJuggler);

        theApp.doSomething();

        assertThat(myOut.toString()).isEqualTo("I don't juggle at all. I am only a Mock.\n");
    }

}
