package workshop.spring.beans;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PartyTest {

    class TestPerformer implements Performer {
        @Override
        public String doSomething() {
            return "I do nothing!";
        }
    }
    @Test
    void testSummerParty() {
        // That's why generally CTOR is prefered over @Autowired annotation:
        Party summerParty = new SummerParty(new TestPerformer());

        String performance = summerParty.start();

        assertThat(performance).isEqualTo("I DO NOTHING!");
    }
}
