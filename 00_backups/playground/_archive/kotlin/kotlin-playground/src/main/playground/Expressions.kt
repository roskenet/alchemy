// Kotlin uses more expressions!

fun main() {
    val name = "Frodo"

    // Here we use if as an EXPRESSION not as a STATEMENT:
    val theString = if (name.equals("Frodo")) "yes" else "no"
    println(theString)

    println(switchMe("Frodo"))
}

// Comparable to a switch/case in other languages:
fun switchMe(hobbit: String) =
    when(hobbit) {
        "Frodo" -> "$hobbit is a Beutlin!"
        "Bilbo" -> "$hobbit is a Beutlin!"
        else -> "Not a Beutlin!"
    }