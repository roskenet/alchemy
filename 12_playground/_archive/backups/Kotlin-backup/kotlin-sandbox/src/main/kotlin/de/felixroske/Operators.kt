package de.felixroske

fun main() {
    var coolClass = MyCoolClass()

    ++coolClass
}

class MyCoolClass {
    operator fun inc(): MyCoolClass {
       println("MyCoolClass incremented!")
        return this
    }
}