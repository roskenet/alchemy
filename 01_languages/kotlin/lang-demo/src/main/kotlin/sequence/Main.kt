package sequence

val mySequence = sequence {
    println("Generating 1")
    yield(1)
    println("Generating 2")
    yield(2)
    println("Generating 3")
    yield(3)
}


fun main() {
    println("Hello, Kotlin!")
    println("The sequence returns: ${mySequence.first()}")

    mySequence.forEach { println(it) }

}
