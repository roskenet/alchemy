package de.felixroske.kotlin

fun coolFunction(param1: Int, param2: Int, thefun: (String) -> Int) {

    val myString: String = "Hallo"

    println("Du hast $param1 und $param2 mitgegeben. Deine Funktion: ${thefun(myString)}")

}

fun main() {
    coolFunction(2, 5) {
       return@coolFunction it.length
    }
}