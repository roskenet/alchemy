package workshop.puzzle001;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Map;

import org.junit.jupiter.api.Test;

class Tests {

    @Test
    void testCharCounter_i() throws Exception {
        var input = "Mississippi";
        
        Map<Character, Integer> result = CharCounter.countCharacters(input);
        
        assertThat(result.get('i'), is(4));
    }

    @Test
    void testCharCounter_M() throws Exception {
        var input = "Magdeburg";
        
        Map<Character, Integer> result= CharCounter.countCharacters(input);
        
        assertThat(result.get('M'), is(1));
    }
    
    @Test
    void testCharCounter_empty() throws Exception {
       var input = "";
       
       Map<Character, Integer> result = CharCounter.countCharacters(input);
       
       assertThat(result.get('A'), is(nullValue()));
    }
    
}
