package kata.enumerablemagic

import kotlin.test.Test
import kotlin.test.assertEquals

//fun include(arr: IntArray, item : Int): Boolean = arr.contains(item)

fun include(arr: IntArray, item : Int): Boolean = item in arr

class TestExample {
  @Test
  fun `Basic Tests`() {
    assertEquals(true, include(intArrayOf(1,2,3,4), 2))
    assertEquals(false, include(intArrayOf(1,2,4,5), 3))
  }
}