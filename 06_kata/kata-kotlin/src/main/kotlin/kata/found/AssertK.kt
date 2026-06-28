package kata.found

import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

fun doSomething(byte: Byte): String {
    return "Magic"
}

class AssertKTest {
    @Test
    fun testDoSomething(): Unit {

        val doSomething = doSomething(1.toByte())

        assertThat(doSomething).isEqualTo("Magic")
    }
}