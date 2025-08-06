package de.petunia

fun main() {

    val capitals = mapOf(
        "Germany" to "Berlin",
        "France" to "Paris",
        "Italy" to "Rome"
    )

    val unknownCapital = capitals["Iceland"]?.let {
       it.uppercase()
    }

    println(unknownCapital)

}
