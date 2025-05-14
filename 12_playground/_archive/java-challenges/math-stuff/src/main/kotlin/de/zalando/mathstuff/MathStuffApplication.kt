package de.zalando.mathstuff

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MathStuffApplication

fun main(args: Array<String>) {
    runApplication<MathStuffApplication>(*args)
}
