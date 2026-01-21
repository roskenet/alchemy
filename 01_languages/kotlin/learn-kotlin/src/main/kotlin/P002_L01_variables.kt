package de.roskenet

fun main() {

    var mutableVariable = 1
    mutableVariable = 2
    println(mutableVariable)

    val immutableVariable = 1
    immutableVariable = 2 // Error!

    // Convention: Variables are (usually) camelCase
    // Kotlin is statically typed. Variables have a type that cannot be changed after initialization.
}