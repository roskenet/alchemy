package codewars.needle;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

class Kata {
  public static String findNeedle(Object[] haystack) {
    for(int x=0; x < haystack.length; x++) {
      if(haystack[x] instanceof String && haystack[x].equals("needle")) {
        return  "found the needle at position " + x;
      }
    }
    return "found the needle nowhere";
  }
}
// return String.format("found the needle at position %d", java.util.Arrays.asList(haystack).indexOf("needle"));

public class NeedleExampleTests {
  @Test
  public void tests() {
    Object[] haystack1 = {"3", "123124234", null, "needle", "world", "hay", 2, "3", true, false};
    Object[] haystack2 = {"283497238987234", "a dog", "a cat", "some random junk", "a piece of hay", "needle", "something somebody lost a while ago"};
    Object[] haystack3 = {1,2,3,4,5,6,7,8,8,7,5,4,3,4,5,6,67,5,5,3,3,4,2,34,234,23,4,234,324,324,"needle",1,2,3,4,5,5,6,5,4,32,3,45,54};
    Object[] haystack4 = {"hay", "junk", "hay", "hay", "moreJunk", "needle", "randomJunk"};
    assertEquals("found the needle at position 3", Kata.findNeedle(haystack1));
    assertEquals("found the needle at position 5", Kata.findNeedle(haystack2));
    assertEquals("found the needle at position 30", Kata.findNeedle(haystack3));
    assertEquals("found the needle at position 5", Kata.findNeedle(haystack4));
  }

  @Test
  public void bewareOfComparingStringsWithEqualEqualOperator() {
    Object[] haystack = { "junk", "more junk", new String("needle"), "gadget" };
    assertEquals("found the needle at position 2", Kata.findNeedle(haystack));
  }
}
