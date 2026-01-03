package de.felixroske.coding

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

val someVal: Int = 0

const val MY_MAGIC_STRING = "The magic String"

fun doSomething(value: String): String {
    println(value)
    return value.toUpperCase()
}

//fun doAnotherThing = (String) -> ::toUpperCase()

class DoSomethingTests {

    @Test
    fun testDoSomething() {
        val doSomething = doSomething(value = "Ein Super Test")

        assertThat(doSomething, `is`("EIN SUPER TEST"))
    }

}