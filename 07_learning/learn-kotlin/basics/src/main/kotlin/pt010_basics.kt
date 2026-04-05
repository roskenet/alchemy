package org.example.part01_basics

fun main() {
    println("The sum of the first 3 squares is: ${calculateSumOfSquares(3)}")
}

fun calculateSumOfSquares(n: Int): Int {
    return (1..n).reduce { acc, i -> acc + i*i }
}


fun calculateSumOfEven(n: Int): Int {

    fun Int.isEven(): Boolean {
        return this % 2 == 0
    }

    return (0..n).filter { it.isEven() }.sum()
}