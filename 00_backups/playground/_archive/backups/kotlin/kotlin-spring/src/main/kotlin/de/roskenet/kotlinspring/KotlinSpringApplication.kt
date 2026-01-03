package de.roskenet.kotlinspring

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

//@SpringBootApplication
//class KotlinSpringApplication

fun main(args: Array<String>) {
    runApplication<KillerAppConfig>(*args)
}
