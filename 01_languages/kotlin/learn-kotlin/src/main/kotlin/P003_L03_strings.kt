package de.roskenet

fun main() {

    println("Hello World!")
    println("Ascapesequences\rEscape")

    val myVal: String = "Hello World!"

    println("""
        But here I can't use \n.
        Can I put ${myVal} here?
        Yes, I can.
    """.trimIndent())

}
