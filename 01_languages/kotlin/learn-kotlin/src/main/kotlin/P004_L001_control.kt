package de.roskenet

//fun Boolean:not(): String = when {
//    this -> println("not false")
//    else -> println("not true")
//}

fun Boolean.tellMe(): String = when {
    this -> "not"
    else -> ""
}

fun main() {
    val x = 42
    println("$x is ${isNonsense(x).tellMe()} nonsense")
}

fun isNonsense(zahl: Int): Boolean =
    when (zahl) {
        42 -> true
        else -> false
    }