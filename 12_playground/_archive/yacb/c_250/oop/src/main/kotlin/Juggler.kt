package de.felixroske

class Juggler(thing: String): Bookable, Performer(thing) {
    override fun perform() {
        println("I am juggling with ${item}.")
    }

    override fun book() {
        println("I was booked now!");
    }
}