package de.zalando.demo

fun main() {
    val a = Double.NaN
    val b = Double.NaN

    println("Are they equal? ${a == b}")
    printComparison(a, b)
}

fun printComparison(a: Any, b: Any) {
    println("What about now? ${a == b}")
}
