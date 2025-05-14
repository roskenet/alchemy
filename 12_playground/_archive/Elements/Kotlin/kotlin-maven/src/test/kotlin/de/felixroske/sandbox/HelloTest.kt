package de.felixroske.sandbox

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import kotlin.test.assertEquals

class HelloTest {

    @Test
    fun testSomething() {
        val myVal = true

        assertThat(myVal).isEqualTo(true)
    }
}
