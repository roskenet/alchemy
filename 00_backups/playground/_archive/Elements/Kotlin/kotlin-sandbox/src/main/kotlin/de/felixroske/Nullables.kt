package de.felixroske

fun main() {

    myFunction(null)
    myFunction("Test")

}

fun myFunction(myString: String?, myInt: Int = 0): String {

    myString?.let { println(it.toUpperCase()) }

    val s = myString.toString();

//    val lowerCase = myString.toLowerCase()

    if (myString != null) {
        println(myString)
        myString.toLowerCase()
    }

    println("42".toLong())

    val i = 1L

    return ""
}