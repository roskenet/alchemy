fun main() {
    println("RGB to CMYK")
    print("Enter RGB as comma seperated string: ")
    val userInput = readln()
    val rgbValues = userInput.split(",").map { it.trim().toInt() }

    val cmykValues = convertRgbToCmyk(rgbValues[0], rgbValues[1], rgbValues[2])

    println("CMYK values: $cmykValues")
}

fun convertRgbToCmyk(r: Int, g: Int, b: Int): String {
   return "R:${r}"
}