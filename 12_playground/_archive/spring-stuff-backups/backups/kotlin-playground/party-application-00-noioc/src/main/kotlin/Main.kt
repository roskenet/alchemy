import de.felixroske.performer.Performer
import de.felixroske.performer.Singer

fun main(args: Array<String>) {
    println("Let's have a party!")

    val performer: Performer = Singer()

    println(performer.doSomething())
}