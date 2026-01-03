package de.felixroske

fun main() {

    val theJClasses = JClasses()

    theJClasses.doSomething()
}

public class FlxKtClass(val myArg: String = "") {

    fun giveMeTheArg() = myArg

    fun doSomething(myInt: Int) {
       println("Hello World not static?")
    }
}

fun FlxKtClass.doSomething(myInt: Int) {
    println("Hello World!")
}
