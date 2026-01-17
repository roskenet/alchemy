package petunia

// Fun with generics

fun <T: Comparable<T>> firstOf(vararg values: T): T {
    return values.first()
}

fun main() {
    val l1: MutableList<Any?> = mutableListOf("A")
    val r1 = l1.first() // the type of r1 is Any?
    l1.add("B") // the expected argument type is Any?

    val l2: MutableList<*> = mutableListOf("A")
    val r2 = l2.first() // the type of r2 is Any?
    //l2.add("B") // ERROR,
    // the expected argument type is Nothing,
    // so there is no value that might be used as an argument
}