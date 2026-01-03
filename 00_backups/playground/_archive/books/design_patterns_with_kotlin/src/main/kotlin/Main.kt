import java.util.*

fun main(args: Array<String>) {
    println("Hello World!")

    val myName = "Anna Konda"
    val myPerson = MyPerson()
    myPerson.name = "Hallo"

    println("The name is: ${myPerson.name}")
}

class MyPerson {
    var name : String = ""
        set(value) {
            field = value.uppercase()
        }
        get() = field.reversed()
}