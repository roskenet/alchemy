package de.roskenet

fun main() {
    MyCoolClass().doSomething()

    val theClass = MyCoolClass()

    theClass.doSomething()
}

class MyCoolClass {
    companion object {
        const val MY_CONSTANT = "Hello, World!"
    }

    var oneInt = 1

    fun doSomething() {
        println("$MY_CONSTANT $oneInt")
    }
}