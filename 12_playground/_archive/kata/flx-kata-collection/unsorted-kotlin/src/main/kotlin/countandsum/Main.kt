package countandsum

import org.junit.Test
import org.junit.Assert.*;

fun countPositivesSumNegatives(input : Array<Int>?) : Array<Int> {

    if (input == null || input.isEmpty()) {
        return emptyArray()
    }
    var count = 0
    var sum = 0
    for (num in input) {
        if (num > 0) {
            count++
        } else {
            sum += num
        }
    }

    return arrayOf(count, sum)
}

class CountPositivesSumNegativesTest {
  @Test
  fun testFixed() {
    assertArrayEquals(arrayOf(10, -65), countPositivesSumNegatives(arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14, -15)))
    assertArrayEquals(arrayOf(8, -50), countPositivesSumNegatives(arrayOf(0, 2, 3, 0, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14)))
  }
}