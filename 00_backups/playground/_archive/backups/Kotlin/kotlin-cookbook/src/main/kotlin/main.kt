fun main(args: Array<String>) {
    val name = "Felix"
    println("Hello $name!")

//    doSomething()
    funWithArrays()
}

fun doSomething() {

    var myName = "Felix"

    val person = Person(first = "Felix", middle = null, last = "Roske")

    println("Du bist also: $person")

}

data class Person(var first: String, var middle: String?, var last: String)

fun playWithConversions() {
    val myChar = '*'
    val myInt = 42
    val myLong = 42L

    val myULong: ULong = 42uL

    val myBinaryValue= 0b00000001

    val myCastedChar = myChar.toInt()
    val toString = myChar.toString()
}

fun funWithArrays() {
    var arr = IntArray(5) { it * 2 }

    arr.forEach { println(it) }
}

