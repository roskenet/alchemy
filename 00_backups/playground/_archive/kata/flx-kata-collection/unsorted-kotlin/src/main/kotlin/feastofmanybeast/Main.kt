package feastofmanybeast

import kotlin.test.assertEquals
import org.junit.Test

fun feast(beast: String, dish: String): Boolean =
    beast.first().equals(dish.first(), ignoreCase = true) && beast.last().equals(dish.last(), ignoreCase = true)


class FeastOfManyBeastTest {
  @Test
  fun testFixed() {
    assertEquals(true, feast("great blue heron", "garlic naan"))
    assertEquals(true, feast("chickadee", "chocolate cake"))
    assertEquals(false, feast("brown bear", "bear claw"))
    assertEquals(true, feast("marmot", "mulberry tart"))
    assertEquals(true, feast("porcupine", "pie"))
    assertEquals(false, feast("electric eel", "lasagna"))
    assertEquals(true, feast("slow loris", "salsas"))
    assertEquals(true, feast("ox", "orange lox"))
    assertEquals(true, feast("blue-footed booby", "blueberry"))
  }
}
