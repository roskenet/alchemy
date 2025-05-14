package de.felixroske

fun testme(vararg names: String) {
    names.forEach(::println)
}

fun main() {
    testme("A", "B", "C")
}