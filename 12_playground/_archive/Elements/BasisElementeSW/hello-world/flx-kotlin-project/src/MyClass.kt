package de.felixroske.kotlin

import java.util.UUID

data class MyClass(val name: String? = null, val id: UUID) {
}

fun main() {

    var mytest: MyClass? = MyClass(
        id = UUID.randomUUID(),
        name = "TestName"
    )

    println("Der Name ist ${mytest?.name}")

    mytest?.let {
        println(it.name)
    }

    doSomething(mytest)?.let {
        println(it)
    }
}

class AnotherClass(var name: String)

fun doSomething(myclass: MyClass?): String? {

    val anotherClass = AnotherClass("Hello")

    print(myclass!!.name)
    anotherClass.name = "AnotherName"

    return anotherClass.name
}
