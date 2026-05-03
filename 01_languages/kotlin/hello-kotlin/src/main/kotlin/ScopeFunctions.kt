package de.petunia

fun main() {

    val capitals = mapOf(
        "Germany" to "Berlin",
        "France" to "Paris",
        "Italy" to "Rome",
    )

    val capital = capitals["Iceland"]?.uppercase() ?: "unknown"
    
    println(capital)

}
