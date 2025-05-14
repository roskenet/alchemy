package de.felixroske.actinium

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ActiniumApplication

fun main(args: Array<String>) {
    runApplication<ActiniumApplication>(*args)
}
