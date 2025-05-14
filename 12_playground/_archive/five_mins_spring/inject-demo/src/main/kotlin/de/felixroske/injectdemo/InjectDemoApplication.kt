package de.felixroske.injectdemo

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class InjectDemoApplication(val performer: List<Performer>) : CommandLineRunner {
    override fun run(vararg args: String?) {
        performer.forEach {
            it.perform()
        }
    }
}

fun main(args: Array<String>) {
    runApplication<InjectDemoApplication>(*args)
}
