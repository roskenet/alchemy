package de.felixroske.coding;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

public class MyClassTest {
    
    @Test
    public void testApp() {
        MyClass myClass = new MyClass();
        
        boolean result = myClass.myMethod();
        
        assertThat(result, is(true));
    }
}
