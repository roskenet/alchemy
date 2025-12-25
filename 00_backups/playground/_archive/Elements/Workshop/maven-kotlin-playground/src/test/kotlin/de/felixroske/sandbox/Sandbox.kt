package de.felixroske.sanbox.de.felixroske.sandbox

import de.felixroske.example.exDoSomething
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

fun myFunction(input: String): String {

    when (input) {
        "Lion" -> return "Hello Lion!"
    }

    return "Nothing to say"
}

//fun exDoSomething(arg: String)  {
//    // Geht das hier?
//    println("DoSomething aus Sandbox.kt")
//}

class MyTestClass {

    @Test
    fun testMyFunction_Lion() {
        assertThat(myFunction("Lion")).isEqualTo("Hello Lion!")
    }

    @Test
    fun testMyFunction_Nothing() {
        assertThat(myFunction(("Cat"))).isEqualTo("Nothing to say")
    }

    @Test
    fun testNothing() {
        TODO("Do something")

        println("Hallo Welt")
    }

    @Test
    fun testDoSomething() {
        exDoSomething("Hello")
    }
}


