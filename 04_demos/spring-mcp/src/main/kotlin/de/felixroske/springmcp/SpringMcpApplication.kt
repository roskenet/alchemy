package de.felixroske.springmcp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringMcpApplication

fun main(args: Array<String>) {
	runApplication<SpringMcpApplication>(*args)
}
