fun main(args: Array<String>) {
    println(doSomething())
}

private fun doSomething(name: String = "Somebody"): String {
    return name.toUpperCase()
}

