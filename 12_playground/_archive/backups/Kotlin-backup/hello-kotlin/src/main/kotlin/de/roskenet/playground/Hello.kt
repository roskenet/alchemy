package de.roskenet.playground

fun main(args: Array<String>) {
//    val myCoolList = listOf("A", "B", "C")
//    println("Hello, World")
    MyUsefulClass.sayHello()
}

class MyUsefulClass {
    companion object {
        fun sayHello() {
            println("Hello World!")
        }
    }
}