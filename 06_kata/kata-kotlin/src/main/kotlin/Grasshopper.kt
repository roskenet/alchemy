package kata.grasshopper

import kotlin.test.Test
import kotlin.test.assertEquals

// https://www.codewars.com/kata/55d24f55d7dd296eb9000030/train/kotlin
// Summation
// Write a program that finds the summation of every number from 1 to num.
// The number will always be a positive integer greater than 0. Your function only
// needs to return the result, what is shown between parentheses
// in the example below is how you reach that result and it's not part of it, see the sample tests.

object GrassHopper {
    fun summation(n: Int): Int {
        return n * (n + 1) / 2
    }
}

class GrassHopperTest {
    @Test
    fun test1() {
        assertEquals(1, GrassHopper.summation(1))
    }

    @Test
    fun test2() {
        assertEquals(36, GrassHopper.summation(8))
    }
}

