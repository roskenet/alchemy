package de.zalando.demo

fun main() {
    val bonus: Int? = 1000
    val salary: Int = 50000

    val total: Int = bonus ?: 0 + salary

    println("You got paid $total dollars!")
}