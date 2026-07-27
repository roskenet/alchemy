package kata.testwriter

import assertk.assertThat
import assertk.assertions.isEqualTo
import kotlin.test.Test

class TestTheTest {
    @Test
    fun testAssert() {
        assertThat(getTheName("ME")).isEqualTo("Elvis")
    }

    private fun getTheName(input: String)  = "Elvis"
}