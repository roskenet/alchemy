package kata.found

import kotlin.test.DefaultAsserter.assertEquals
import kotlin.test.Test
import kotlin.test.assertEquals

//Your job is to write a function which increments a string, to create a new string.
//
//If the string already ends with a number, the number should be incremented by 1.
//If the string does not end with a number. the number 1 should be appended to the new string.
//
//Examples:
//
//foo -> foo1
//
//foobar23 -> foobar24
//
//foo0042 -> foo0043
//
//foo9 -> foo10
//
//foo099 -> foo100
//
//Attention: If the number has leading zeros the amount of digits should be considered.

fun incrementString(arg: String): String {
    return ""
}

class TestsSuite {
    @Test
    fun sampleTests() {
        doTest("", "1")
        doTest("010", "011")
        doTest("999", "1000")
        doTest("foobar000", "foobar001")
        doTest("foobar999", "foobar1000")
        doTest("foobar00999", "foobar01000")
        doTest("foo", "foo1")
        doTest("foobar001", "foobar002")
        doTest("fo99obar99", "fo99obar100")
        doTest("foobar1", "foobar2")
        doTest("1", "2")
        doTest("", "1")
        doTest("009", "010")
    }

    private fun doTest(input: String, expected: String) {
        val message = String.format("for input: \"%s\"\n", input);
        val actual_ = incrementString(input);
        assertEquals(expected, actual_, message);
    }
}