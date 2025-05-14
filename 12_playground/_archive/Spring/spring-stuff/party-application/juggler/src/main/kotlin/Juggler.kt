package de.felixroske.performer

class Juggler(val item: String, val num: Int) : Performer {
    override fun doSomething(): String {
        return "I am juggling with ${num} ${item}!"
    }
}