package de.felixroske.ch_02.ex_001

fun main() {
    val theNumber = 7

    val sieve = Eratosthenes()

    println("We check if ${theNumber} is prime: ${if (sieve.isPrime(theNumber)) "yes" else "no"}")
}

// TODO:
// This is not a real Sieve of E.
class Eratosthenes {
    private val ints: ArrayList<Int> = arrayListOf()

    fun isPrime(potPrime: Int): Boolean {
        (2..potPrime/2).toList().forEach {
            ints.add(it)
        }
        ints.forEach {
            if (potPrime % it == 0) {
                return false
            }
        }

        return true
    }
}