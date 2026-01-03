package de.felixroske.coroutinestudy

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    val measureTimeMillis = measureTimeMillis {
        val name = async { getName() }
        val doSomething = async { doSomething() }
        println("Hallo ${name.await()} in the repo ${doSomething.await()}")
    }

    println("Programm finished in $measureTimeMillis ms")
}

suspend fun getName(): String {
    delay(1000L)
    return "Felix"

}

suspend fun doSomething(): String {
    delay(1000L)
    return "Playground"
}