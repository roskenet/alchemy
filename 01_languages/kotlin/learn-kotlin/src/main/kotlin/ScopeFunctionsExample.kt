package de.roskenet

// https://kotlinlang.org/docs/scope-functions.html
// let, run, with, apply, also,

class ScopeFunctionsExample {
    fun example() {
        val example = null
        example.let {
            println(it)
        }
    }
}

fun main() {
//    ScopeFunctionsExample().example()
//    var me = "  Felix"
//    me.let {
//        me = it.uppercase()
//        println(it.trim().uppercase())
//    }

    val numbers = mutableListOf("one", "two", "three")

    val filterChar = 'e'

    val countEndsWithE = numbers.run {
        add("four")
        add("five")
        count { it.endsWith(filterChar) }
    }

    println("There are $countEndsWithE elements that end with e.")
}