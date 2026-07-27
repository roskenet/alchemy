package de.roskenet

fun main() {
    // The usual "Hello World" has only output.
    // We want to input something!

    print("Please insert your name: ")
    val name = readln().trim()
    println("Hello ${name}!")

}