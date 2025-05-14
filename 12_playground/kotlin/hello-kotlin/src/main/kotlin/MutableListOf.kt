package de.felixroske


fun doSomethingWithCities(index: Int, city: String): String {
   return "$index: $city"
}

fun main() {

    val citySet = setOf("Berlin", "Hamburg", "Berlin", "Stuttgart")
        .sorted()
        .mapIndexed(::doSomethingWithCities)

    println(citySet)
}
