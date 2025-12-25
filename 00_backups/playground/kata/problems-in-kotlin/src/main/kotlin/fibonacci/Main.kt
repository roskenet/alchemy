package de.roskenet.fibonacci

fun main() {
    val number: Long = 10L

    println("""
        Fibonacci number ${number}: ${fibonacci(number)}
    """.trimIndent())
}

fun fibonacci(n: Long): Long = when (n) {
    0L -> 0L
    1L -> 1L
    else -> fibonacci(n - 1) + fibonacci(n - 2)
}