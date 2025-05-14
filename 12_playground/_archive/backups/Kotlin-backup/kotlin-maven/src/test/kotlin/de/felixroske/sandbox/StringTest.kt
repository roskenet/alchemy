package de.felixroske.sandbox

import org.junit.Test

class StringTest {

    @Test
    fun testMyString() {
        val myString = "Hello World!"

        val c = myString[1]

        println("Index 1: $c")
    }

}