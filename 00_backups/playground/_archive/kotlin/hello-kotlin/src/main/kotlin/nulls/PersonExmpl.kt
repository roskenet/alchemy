package nulls

fun main() {
    class Person(
        val first: String,
        val middle: String?,
        val last: String
    )

    val jkRowling = Person("Joanne", null, "Rowling")
    val northWest = Person("North", null, "West")

    var theKing = Person("Elvis", null, "Presley")

    val middleLength = theKing.middle?.length ?: 0

}