package org.example

data class Performer(
    var name: String,
    var action: String) {
}


fun main() {
    println("Hello World!")
    val performer = Performer("Elvis", "Singer")
}