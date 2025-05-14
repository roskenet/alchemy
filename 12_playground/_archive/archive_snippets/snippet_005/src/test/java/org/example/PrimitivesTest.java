package org.example;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

public class PrimitivesTest {

    @Test
    public void shouldAnswerWithTrue() {
        assertThat(1 == 1, is(true));
    }
}
