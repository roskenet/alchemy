package de.roskenet

@JvmInline
value class Lamps(private val bits: Int) {

    fun isOn(index: Int): Boolean =
        bits and (1 shl index) != 0

    override fun toString(): String =
        (3 downTo 0)
            .joinToString(" ") { if (isOn(it)) "1" else "0" }

    companion object {
        fun of(vararg on: Int): Lamps =
            Lamps(on.fold(0) { acc, i -> acc or (1 shl i) })
    }
}

fun main() {
    println("Hello World!")

    val myLamp = Lamps.of(1, 2, 3, 4)

    (myLamp != null)

    println(myLamp.toString())
}
