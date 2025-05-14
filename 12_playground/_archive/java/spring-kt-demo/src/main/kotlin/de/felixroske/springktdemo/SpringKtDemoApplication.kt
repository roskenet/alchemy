package de.felixroske.springktdemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringKtDemoApplication

fun main(args: Array<String>) {
    runApplication<SpringKtDemoApplication>(*args)
}
