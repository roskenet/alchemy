package de.roskenet.kotlinspring

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component
import java.time.ZonedDateTime

@SpringBootApplication
class KotlinSpringApplication

fun main(args: Array<String>) {
    runApplication<KotlinSpringApplication>(*args)
}

@Component
class WorkingClass: CommandLineRunner {

    companion object Hello {
        fun sayHello() {
            println("Hello World!")
        }
    }

    override fun run(vararg args: String?) {
        val now = ZonedDateTime.now()
        println("Hello World! Es ist jetzt: $now")

        sayHello()
    }
}