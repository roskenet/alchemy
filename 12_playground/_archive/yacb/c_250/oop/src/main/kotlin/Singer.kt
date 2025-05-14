package de.felixroske

class Singer(song: String): Performer(song) {
    override fun perform() {
        println("I'm singing: A little less conversation, a little more action. ${item}")
    }
}