
fun greet(name: String) {
    println("Hello $name")
}


fun main(args: Array<String>) {
    println("Hello World!")

    val x = 42

    // if is an expression in Kotlin:
    val i = if (x > 42) 1 else 0

    println("Result is: $i")

    val myArray = intArrayOf(1, 42, 1212)

    val theReducer = myArray.reduce { myAcc, theInt -> myAcc + theInt }
    val sum = myArray.sum()

    val sum1 = myArray.map {
        it + 1
    }

    println("Wert des Reducers ist: $theReducer")
    println("Wert der Summe: $sum")
    println("Wert der zweiten Summe: ${sum1.sum()}")
}

