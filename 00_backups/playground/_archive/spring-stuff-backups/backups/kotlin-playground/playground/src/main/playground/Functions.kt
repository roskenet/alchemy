// The functional side of Kotlin

fun main(args: Array<String>) {
    println("The functional side of Kotlin")

    // We define our own lambda: See how we can explicitly move it out of the parameter list:
    val result = doSomething("Test Me!") { input -> input.reversed() }

    // We call doSomething with a function reference: (GoF Strategy Pattern)
//    val result = doSomething("Test Me!", ::mutator)

    println(result)
}

fun mutator(input: String): String {
    return input.uppercase()
}

// A typealias like this
typealias StringMutator = (String) -> (String)

// makes the code elegant:
fun doSomething(value: String, funcToBeApplied: StringMutator): String  {
   return funcToBeApplied(value)
}
