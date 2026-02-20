package sequence

import java.math.BigInteger

val fibonacci = sequence {
    var first = 0.toBigInteger()
    var second = 1.toBigInteger()
    while (true) {
        yield(first)
        val temp = first
        first += second
        second = temp
    }
}

val factorial: Sequence<BigInteger> = sequence {
    var current = 1.toBigInteger()
    var counter = 1.toBigInteger()
    yield(current) // 0! = 1
    while (true) {
        current = current * counter++
        yield(current)
    }
}

fun main() {
    println("Hello, Kotlin!")

    factorial.take(5).forEach { println(it) }
}
