// Kotlin can do "usual" object oriented programming:
fun main() {
    var theGreeter = HelloGreeter()
    println(theGreeter.greetMe("Anna"))

    println("Decorated String".decorate("*"))
}

interface Greeter {
    fun greetMe(name: String): String
}

class HelloGreeter: Greeter {
    override fun greetMe(name: String): String = "Hello $name"
}

// Extension Functions: Called monkey patching in other languages:
fun String.decorate(string: String): String {
    return "$string $this $string"
}