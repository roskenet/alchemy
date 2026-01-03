package arrays_and_lists

fun main() {
    println("Hello World!")

//    val juggler = Juggler()
//    checkPerformer(juggler)

    fun myFilterFunction(arg: String): Boolean =
        arg.startsWith('R')

//    doSomethingWithArrays()
    val listOfCities = listOf("New York", "Rio", "Tokyo")
    listOfCities.filter {
        myFilterFunction(it)
    }.forEach {
        println(it)
    }

//
//    val capitals = mutableListOf("Berlin", "Bern", "Beijing")
//    println("Cities with B: ${capitals.joinToString()}")
}

private fun doSomethingWithArrays() {
    val letters = arrayOf("A", "B", "C", "D")
    println(letters.lastIndexOf("E"))
}

private fun checkPerformer(performer: Performer) {
    performer.doSomething("Swords")
}