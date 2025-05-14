package de.felixroske.charcount;


import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void shouldAnswerWithTrue()
    {
        assertThat(true).isEqualTo(true);
        var characterIntegerHashMap = new HashMap<Character, Integer>();
        var a = characterIntegerHashMap.get('a');

    }
}
