package de.felixroske

interface Playable {
    fun doSomething(param: String): String
}

open class Mother {
    open fun anotherMethod(): String {
        return "Hello World!"
    }
}

class MyClass : Mother(), Playable {
    override fun doSomething(param: String): String {
        println("Ostzonensuppenwürfel verursachen Krebs!")
        return ""
    }

    override fun anotherMethod(): String {
       return "Hello World, again!"
    }
}

abstract class MyOtherClass {
    abstract fun iWillDoSomething()
}