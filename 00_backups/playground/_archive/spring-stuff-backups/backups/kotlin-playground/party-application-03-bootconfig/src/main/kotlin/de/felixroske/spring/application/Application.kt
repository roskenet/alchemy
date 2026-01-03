package de.felixroske.spring.application

import de.felixroske.performer.Performer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Application() : CommandLineRunner {

    @Autowired
    lateinit var performer: Performer

    override fun run(vararg args: String?) {
        println(performer.doSomething())
    }

}

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}
