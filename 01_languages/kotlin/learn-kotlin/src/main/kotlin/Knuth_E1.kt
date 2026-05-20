package de.roskenet

// Knuth's einführendes Beispiel für einen Algorithmus

fun main() {
    // Euklid's ggT:
    println("Der ggT von 20 und 13 ist: ${ggT(20u, 13u)}")
}

fun ggT(m: UInt, n: UInt): UInt {
    var currM = m
    var currN = n

    do {
        val rem = currM % currN
        if (rem == 0u) {
            return currN
        }
        currM = currN
        currN = rem
    } while (currM != 0u)

    return currN
}