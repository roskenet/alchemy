fun main() {

    var myString = "Hello"

    val retString = changeMe(myString)

    retString?.let {
        println(it)
    }.let { println("Hello World!") }

}

fun changeMe(theString: String): String? {
//    val randomNumber = Math.random() * 10
    val randomNumber = 41.0
    val isOdd = randomNumber % 2 == 1.0

    if (isOdd) return null

    return theString.uppercase()
}