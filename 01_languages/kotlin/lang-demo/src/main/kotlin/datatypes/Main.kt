package datatypes

fun main(args: Array<String>) {

    var theDoubleString = "3.1415926"

    var asDouble: Double = try {
        theDoubleString.toDouble()
    } catch (e: Exception) {
        println("Geht nicht")
        0.0
    }

    println("The type of asDouble is ${asDouble::class.qualifiedName}")
    println("The value of asDouble is $asDouble")

}