package de.roskenet.javacoding;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

public class AppTest
{
    @Test
    public void shouldAnswerWithTrue()
    {
        assertThat( 2 == 2, is(true) );
    }
}
