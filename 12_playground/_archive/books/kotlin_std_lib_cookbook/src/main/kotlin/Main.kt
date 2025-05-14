fun main() {
    println("Hello World!")

    val days = 1..365
    val searchFor = 1234

    val contains = days.contains(searchFor)
    val count = days.count {
        it % 2 == 0
    }

    println("My range does${if (!contains) " not" else ""} contain ${searchFor}.")
    println("It has ${count} even members.")
}