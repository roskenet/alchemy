package de.roskenet;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AppTest
{
    @Test
    public void shouldAnswerWithTrue()
    {
        assertThat( 2 + 2 == 4, is(true));
    }
}
