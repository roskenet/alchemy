package de.zalando.hellomaven;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Write a test here")
public class MavenHelloWorldTest {

    @Test
    void testName() throws Exception {
        assertThat(Boolean.valueOf("true"), is(true));
    }
}
