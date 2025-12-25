package de.felixroske.Chapter8

class FunctionTypes {
    val sum = { x: Int, y: Int -> x + y }
    val mult = {x: Int, y: Int -> x*y}

    val action = { println(42) }

   fun doSomething(): List<String> {
       val listOf = listOf("Eins", "Zwei", "Drei")
       return listOf
   }

    fun doSomethingElse() {
        val (a, b, c)  = doSomething()

        val toLowerCase = a.toLowerCase()

        println(toLowerCase)
    }

}

fun main() {
    val functionTypes = FunctionTypes()

    functionTypes.doSomethingElse()

    functionTypes.action();
}

