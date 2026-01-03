package de.felixroske.coding

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.CoreMatchers.`is`
import org.junit.Test
import kotlin.test.assertEquals

class HelloTest {

    @Test
    fun testSomething() {


        val result = true

        assertThat(result, `is`(true))
    }

}
