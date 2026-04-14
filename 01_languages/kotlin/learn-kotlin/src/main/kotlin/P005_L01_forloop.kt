package de.roskenet

enum class Continent(val continentName: String) {
    AFRICA("Africa"),
    EUROPE("Europe"),
    NORTH_AMERICA("North America"),
    SOUTH_AMERICA("South America"),
    ASIA("Asia"),
    OCEANIA("Oceania"),
}

data class City(val name: String, val continent: Continent, val isCapital: Boolean) {
    override fun toString(): String {
        return "$name is ${if(isCapital) "a capital" else "a city"} in ${continent.continentName}"
    }
}

fun main() {

    val cities = listOf(
        City("Athens", Continent.EUROPE, isCapital = true),
        City("Berlin", Continent.EUROPE, isCapital = true),
        City("Dublin", Continent.EUROPE, isCapital = true),
        City("Osaka", Continent.ASIA, isCapital = false),
        City("Sao Paulo", Continent.SOUTH_AMERICA, isCapital = false),
        City("Sydney", Continent.OCEANIA, isCapital = false),
        City("Vancouver", Continent.NORTH_AMERICA, isCapital = false),
        City("Windhoek", Continent.AFRICA, isCapital = true),
    )

    for ((name, continent) in cities) {
       println("$name, $continent")

    }

//    for (c in cities.indices) {
//        println(cities[c])
//    }

//    val partition = cities.partition { it.isCapital }
//    println(partition.first)
}