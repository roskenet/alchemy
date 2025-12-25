package de.roskenet.kata;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class DivisionChecker {

   @ParameterizedTest
   @CsvSource({"10, 5, yes", "11, 2, no"})
   void testDivisionChecker(int num, int div, String expectedResult) {
      String result = DivisionChecker.check(num, div);

      assertThat(result).isEqualTo(expectedResult);
   }

   private static String check(int num, int div) {
      return (num % div == 0) ? "yes" : "no";
   }
}
