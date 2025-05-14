package de.felixroske.injectdemo

import org.springframework.stereotype.Component

@Component
class Juggler: Performer {
    override fun perform() {
        println("I am juggling")
    }
}

@Component
class Singer: Performer {
    override fun perform() {
        println("I am singing")
    }
}

@Component
class Dancer: Performer {
    override fun perform() {
        println("I am dancing")
    }
}