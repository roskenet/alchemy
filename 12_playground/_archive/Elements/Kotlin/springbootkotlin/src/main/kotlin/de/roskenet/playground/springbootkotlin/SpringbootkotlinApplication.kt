package de.roskenet.playground.springbootkotlin

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringbootkotlinApplication(val theWorker: Usable): CommandLineRunner {
	override fun run(vararg args: String?) {
        theWorker.doSomething("Felix")
		println("Hello World!")
	}
}

fun main(args: Array<String>) {
	runApplication<SpringbootkotlinApplication>(*args)
}
