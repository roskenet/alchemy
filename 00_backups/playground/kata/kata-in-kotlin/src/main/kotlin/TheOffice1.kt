package kata.office1

import kotlin.test.Test
import kotlin.test.assertEquals

// https://www.codewars.com/kata/57ecf6efc7fe13eb070000e1/train/kotlin

fun outed(meet: Map<String, Int>, boss: String): String {
    return if (((meet.values.sum() + meet.getOrDefault(boss, 0)) / meet.size) <= 5) "Get Out Now!" else "Nice Work Champ!"
}

class TestExample {
    @Test
    fun testFixed() {
        assertEquals("Get Out Now!", outed(mapOf("tim" to 0, "jim" to 2, "randy" to 0, "sandy" to 7, "andy" to 0, "katie" to 5, "laura" to 1, "saajid" to 2, "alex" to 3, "john" to 2, "mr" to 0), "laura"))
        assertEquals("Nice Work Champ!", outed(mapOf("tim" to 1, "jim" to 3, "randy" to 9, "sandy" to 6, "andy" to 7, "katie" to 6, "laura" to 9, "saajid" to 9, "alex" to 9, "john" to 9, "mr" to 8), "katie"))
        assertEquals("Get Out Now!", outed(mapOf("tim" to 2, "jim" to 4, "randy" to 0, "sandy" to 5, "andy" to 8, "katie" to 6, "laura" to 2, "saajid" to 2, "alex" to 3, "john" to 2, "mr" to 8), "john"))
    }
}
