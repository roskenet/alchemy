package strtoint

import kotlin.test.assertEquals
import org.junit.Test

fun stringToNumber(str: String): Int = str.toInt()

class StringToNumberTest {
    @Test
    fun sampleTests() {
        assertEquals(1234, stringToNumber("1234"))
        assertEquals(605, stringToNumber("605"))
        assertEquals(1405, stringToNumber("1405"))
        assertEquals(-7, stringToNumber("-7"))
    }
}