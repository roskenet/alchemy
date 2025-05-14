package kata.fixstringcase

import kotlin.test.Test
import kotlin.test.assertEquals

// https://www.codewars.com/kata/5b180e9fedaa564a7000009a/train/kotlin

object FixStringCase {
    fun solve(s: String): String
        = if (s.filter { it.isLowerCase() }.length >= s.filter { it.isUpperCase() }.length)
            s.lowercase()
                else
            s.uppercase()
}

class FixStringCaseSolutionTest {
    @Test
    fun BasicTests() {
        assertEquals("code", FixStringCase.solve("code"))
        assertEquals("CODE", FixStringCase.solve("CODe"))
        assertEquals("code", FixStringCase.solve("COde"))
        assertEquals("code", FixStringCase.solve("Code"))
        assertEquals("", FixStringCase.solve(""))
    }
}
