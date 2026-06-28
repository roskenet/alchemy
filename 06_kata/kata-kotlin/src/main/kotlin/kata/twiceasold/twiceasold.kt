package kata.twiceasoldsecond

import kotlin.test.Test
import kotlin.test.assertEquals

fun twiceAsOld(dadYearsOld: Int, sonYearsOld: Int): Int {
    // 36 - 2 * 7 = 22
    // 55 - 2 * 30 = -5
    return Math.abs(dadYearsOld - 2 * sonYearsOld)
}

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
