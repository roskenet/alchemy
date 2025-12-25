package de.felixroske.kotlin

data class MyDataClass(val name: String, val age: Int, var single: Boolean)

fun main(args: Array<String>) {
    println("Hello, World")
}

fun max(a: Int, b: Int) = if (a > b) a else b

