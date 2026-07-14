package de.roskenet

fun main() {
//   val myString = "ThisIsLine00042"
   val myString = "ThisIsLine"
   val regex = Regex("""(?<text>.*0*)(?<number>\d+)$""")

    val find = regex.find(myString)
    val text = find?.groups["text"]?.value
    val number = find?.groups["number"]?.value?.toInt()?.plus(1)

    println("$text$number")
}
