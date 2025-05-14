package de.roskenet.programming;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Rule;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.jupiter.api.Test;

public class MyTest {
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule();

    @Test
    public void writesTextToSystemOut() {
        systemOutRule.enableLog();
        System.out.println("hello world");
        String log = systemOutRule.getLog();
        System.out.println("and me again!");
        assertEquals("hello world", systemOutRule.getLog());

    }
}
