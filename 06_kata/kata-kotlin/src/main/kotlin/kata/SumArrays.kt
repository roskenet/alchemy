package solution.kata

import kotlin.test.assertEquals
import kotlin.test.Test

object Kata {

    fun sumArray(array: DoubleArray): Double {
        return array.sum()
    }
}

class KataTest {

    @Test
    fun `sample test`() {

        assertEquals(9.2, Kata.sumArray(doubleArrayOf(1.0, 5.2, 4.0, 0.0, -1.0)))
        assertEquals(0.0, Kata.sumArray(doubleArrayOf()))
    }
}
