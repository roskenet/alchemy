package workshop.spring.beans;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PartyTest {

    class TestPerformer implements Performer {
        @Override
        public String doSomething() {
            return "NOTHING";
        }
    }
    @Test
    void testSummerParty() {
        Party summerParty = new SummerParty(new TestPerformer());

        String performance = summerParty.start();

        assertThat(performance).isEqualTo("NOTHING");
    }
}
