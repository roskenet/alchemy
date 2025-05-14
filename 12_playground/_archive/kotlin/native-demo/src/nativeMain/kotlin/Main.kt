fun main() {

    var x = 42
    x = 43

    println("Hello, x is $x")

    datatypes()
}

fun datatypes() {
    // Kotlin doesn't know primitive types!
    var var1 = 0b101
    println("var1 is: $var1")
}

fun loops() {
    var counter = 0

    // while:
    while (counter < 42) {
       counter++
    }

    // do while:
    do {
        counter++
    } while (counter < 42)
}
