fun main() {
    val result = fibonacci(8)

    println("Result is: ${result}")
}

fun fibonacci(idx: Int): Int {
   if (idx < 2)
      return idx
   else
      return fibonacci(idx - 1) + fibonacci(idx - 2)
}