package destructuring

data class Artist(val name: String, val age: Int, val gernre: String)

fun getElvis() = Artist("Elvis Presley", 45, "Rock")

fun getRickRoll() = Pair("https://www.youtube.com/watch?v=dQw4w9WgXcQ", "Rick Roll")

fun main() {

    val (name, age, genre) = getElvis()
    println("$name was $age and played $genre.")

    val (url, title) = getRickRoll()
    println("$title: $url")

}