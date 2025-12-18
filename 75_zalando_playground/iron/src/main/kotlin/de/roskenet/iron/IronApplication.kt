package de.roskenet.iron

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class IronApplication

fun main(args: Array<String>) {
	runApplication<IronApplication>(*args)
}
