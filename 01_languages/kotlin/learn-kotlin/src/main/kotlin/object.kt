package de.roskenet

interface MyInterface

object MyObject: MyInterface

fun main() {
    println("Hello, Kotlin!")

    println(MyObject)
    doSomething(MyObject)
}

fun doSomething(parameter: MyInterface) {

}