package kata.twiceasold

import kotlin.math.abs
import kotlin.test.Test
import kotlin.test.assertEquals

// https://www.codewars.com/kata/5b853229cfde412a470000d0/train/kotlin

fun twiceAsOld(dadYearsOld: Int, sonYearsOld: Int) = abs(2 * sonYearsOld - dadYearsOld)

class TestExample {
    @Test
    fun testFixed() {
        assertEquals(22, twiceAsOld(36,7))
        assertEquals(5, twiceAsOld(55,30))
        assertEquals(0, twiceAsOld(42,21))
        assertEquals(20, twiceAsOld(22,1))
        assertEquals(29, twiceAsOld(29,0))
    }
}
