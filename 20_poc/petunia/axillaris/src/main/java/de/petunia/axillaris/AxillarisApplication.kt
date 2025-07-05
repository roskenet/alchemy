package de.petunia.axillaris

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class AxillarisApplication

fun main(args: Array<String>) {
    runApplication<AxillarisApplication>(*args)
}
