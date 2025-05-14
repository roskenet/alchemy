package de.roskenet

fun main() {
    println("Hello Datatypes!")

    // Kotlin has the "usual" datatypes
    val unsignedByte: UByte = 42u // 8 Bit
    val unsignedShort: UShort = 42u // 16 Bit
    val unsignedInt: UInt = 42u // 32 Bit
    val unsignedLong: ULong = 42u // 64 Bit

    val byte: Byte = 42
    val short: Short = 42
    val int: Int = 42
    val long: Long = 42

    val float: Float = 3.14f
    val double: Double = 3.14
    val char: Char = 'A'
    val boolean: Boolean = true
    val string: String = "Hello"
}

fun doSomething(param: String) {
    println(param.uppercase())
}