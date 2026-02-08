package codewars.intonly;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

//In this kata you will create a function that takes a list of non-negative integers and strings and returns a new list with the strings filtered out.

class Kata {
  public static List<Integer> filterList(final List<Object> list) {
    return list.stream()
            .filter(e -> e instanceof Integer)
            .map(e -> (Integer) e)
            .toList();
  }
}

public class ExampleTests {
  @Test
  public void examples() {
    assertEquals(List.of(1, 2), Kata.filterList(List.of(1, 2, "a", "b")), "For input: [1, 2, \"a\", \"b\"]");
    assertEquals(List.of(1, 0, 15), Kata.filterList(List.of(1, "a", "b", 0, 15)), "For input: [1, \"a\", \"b\", 0, 15]");
    assertEquals(List.of(1, 2, 123), Kata.filterList(List.of(1, 2, "aasf", "1", "123", 123)), "For input: [1, 2, \"aasf\", \"1\", \"123\", 123]");
  }

  public static void main(String[] args) {
    List<Object> list = List.of(1, 2, "a", "b");

  }

}