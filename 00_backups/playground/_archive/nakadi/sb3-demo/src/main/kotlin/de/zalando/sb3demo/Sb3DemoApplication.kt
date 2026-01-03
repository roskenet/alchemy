package de.zalando.sb3demo

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Sb3DemoApplication : CommandLineRunner {

    override fun run(vararg args: String?) {

    }
}

fun main(args: Array<String>) {
    runApplication<Sb3DemoApplication>(*args)
}
