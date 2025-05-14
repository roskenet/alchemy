package codingproblems;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Map;
import org.junit.jupiter.api.Test;

public class CharCountTest {

   @Test
   void testCountChars() {
       var word = "Panamakanalskandal";

       Map<Character, Long> result = CharCount.countLetters(word);

       assertThat(result.get('a')).isEqualTo(7);
   }
}
