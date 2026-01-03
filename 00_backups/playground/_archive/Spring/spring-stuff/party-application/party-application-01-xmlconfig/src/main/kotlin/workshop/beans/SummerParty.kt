package workshop.beans

import de.felixroske.performer.Performer

class SummerParty(val performer: Performer) : Party {

    override fun start() {
        println(performer.doSomething())
    }
}