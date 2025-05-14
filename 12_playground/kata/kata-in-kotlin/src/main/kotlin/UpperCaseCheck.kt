package kata.uppercasecheck

import kotlin.test.*

// Create a method to see whether the string is ALL CAPS.

fun String.isUpperCase(): Boolean = this.uppercase() == this


class TestExample {
  @Test
  fun testUpperCase() {
    assertFalse("c".isUpperCase(), "Input: 'c'")
    assertTrue("C".isUpperCase(), "Input: 'C'")
    assertFalse("hello I AM DONALD".isUpperCase(), "Input: 'hello I AM DONALD'")
    assertTrue("HELLO I AM DONALD".isUpperCase(), "Input: 'HELLO I AM DONALD'")
    assertFalse("ACSKLDFJSgSKLDFJSKLDFJ".isUpperCase(), "Input: 'ACSKLDFJSgSKLDFJSKLDFJ'")
    assertTrue("ACSKLDFJSGSKLDFJSKLDFJ".isUpperCase(), "Input: 'ACSKLDFJSGSKLDFJSKLDFJ'")
  }
}