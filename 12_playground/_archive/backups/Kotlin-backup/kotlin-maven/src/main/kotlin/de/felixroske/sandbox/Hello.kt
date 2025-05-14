package de.felixroske.sandbox

fun main(args: Array<String>): Unit {
    println("Hello, World")
}

fun playWithExpressions(parameter: String): Boolean {
    return if(parameter.startsWith("A"))
        doReturnTRUE()
    else
        doReturnFALSE()
}

fun doReturnTRUE(): Boolean {
    return true
}

fun doReturnFALSE(): Boolean {
    return false
}