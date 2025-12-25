package de.zalando.vanilla

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class VanillaAppApplication

fun main(args: Array<String>) {
    runApplication<VanillaAppApplication>(*args)
}
