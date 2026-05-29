package de.roskenet

// Knuth's einführendes Beispiel für einen Algorithmus

fun main() {
    // Euklid's ggT:
    val m = 20u
    val n = 5u

    println("Der ggT von $m und $n ist: ${ggT(m, n)}")
}

fun ggT(m: UInt, n: UInt): UInt {
    var currM = m
    var currN = n

    while (true) {
        val rem = currM % currN
        if (rem == 0u) {
            return currN
        }
        currM = currN
        currN = rem
    }
}

