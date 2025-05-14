package kata.highandlow

import kotlin.test.Test
import kotlin.test.assertEquals

// https://www.codewars.com/kata/554b4ac871d6813a03000035/train/kotlin

fun highAndLow(numbers: String): String {
    val maxNumber = numbers.split(" ").map { it.toInt() }.max()
    val minNumber = numbers.split(" ").map { it.toInt() }.min()

    return "$maxNumber $minNumber"
}

class TestExample {
    @Test
    fun test1() {
        assertEquals("42 -9", highAndLow("8 3 -5 42 -1 0 0 -9 4 7 4 -4"))
    }

    @Test
    fun test2() {
        assertEquals("3 1", highAndLow("1 2 3"))
    }
}