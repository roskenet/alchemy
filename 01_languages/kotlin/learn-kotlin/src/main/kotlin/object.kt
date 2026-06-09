package de.roskenet

interface MyInterface {
    fun doSomething() = println("Doing something")
}

object MyObject: MyInterface

fun main() {
    println("Hello, Kotlin!")

    println(MyObject)
    doSomething(MyObject)
}

fun doSomething(parameter: MyInterface) {
    parameter.doSomething()
}