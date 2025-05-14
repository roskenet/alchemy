package kata.multiplication

import kotlin.test.Test
import kotlin.test.assertTrue

// https://www.codewars.com/kata/534d2f5b5371ecf8d2000a08/train/kotlin

object KataSolution {
    fun multiplicationTable(size: Int): Array<IntArray> =
        Array(size) {
            i -> IntArray(size) { j -> (j+1) * (i+1) }
        }
}

class ExampleTests {
    private fun Array<IntArray>.stringify(): String = "[\n" + Array(this.size,{ "  [ " + this[it].map { n -> n.toString() }.joinToString(", ") + " ]" }).joinToString("\n") + "\n]"

    @Test fun `Basic Test`() {
        val size = 3
        val user = KataSolution.multiplicationTable(size)

        val sol = arrayOf(
            intArrayOf(1,2,3),
            intArrayOf(2,4,6),
            intArrayOf(3,6,9)
        )

        assertTrue(user.contentDeepEquals(sol), "Expected:\n${sol.stringify()}\nGot:\n${user.stringify()}")
    }
}