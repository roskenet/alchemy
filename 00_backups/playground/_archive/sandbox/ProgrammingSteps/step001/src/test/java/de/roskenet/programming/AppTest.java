package de.roskenet.programming;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Rule;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    @DisplayName("Hamcrest matchers")
    public void shouldAnswerWithTrue() {
        assertThat(true, is(true));
    }

    @Test
    @DisplayName("Capturing output")
    public void captureLogOutput() {
        App.main(null);
        assertThat(systemOutRule.getLog(), is("Hello World!"));
    }

    @Test
    @DisplayName("Capturing output")
    public void captureOutput() {
        System.out.print("hello");
        assertThat(systemOutRule.getLog().trim(), is("hello"));
    }
}
