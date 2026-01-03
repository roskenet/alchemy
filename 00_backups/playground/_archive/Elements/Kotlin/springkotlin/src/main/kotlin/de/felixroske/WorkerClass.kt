package de.felixroske

fun main() {

    val theJClasses = JClasses()

    theJClasses.doSomething()
}

public class FlxKtClass(val myArg: String = "") {

    fun giveMeTheArg() = myArg
}

fun FlxKtClass.doSomething(myInt: Int) {
    println("Hello World!")
}
