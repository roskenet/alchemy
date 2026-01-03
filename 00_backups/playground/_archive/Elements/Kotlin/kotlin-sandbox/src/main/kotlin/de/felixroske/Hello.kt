package de.felixroske

class Hello(val name: String, var isMarried: Boolean) {

    fun doSomething() {
        println("Hello $name. You are ${if (isMarried) "married" else "not married"}")
    }
}

fun main(args: Array<String>) {
    println("Hello, World")

    val operator = "Hello" // This is o.k.: operator is a 'soft keyword'
    val data = "My Data"

    val hello = Hello("Felix", false)

    hello.isMarried = false

    hello.doSomething()
}

