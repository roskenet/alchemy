package operatoroverload

//operator fun String.compareTo(other: String): Int {
//    return this.length - other.length
//}

fun main() {
    val berlin = "Berlin"
    val hamburg = "Hamburg"
    val frankfurt = "Frankfurt"

    println(berlin > hamburg)
    println(hamburg > frankfurt)
}