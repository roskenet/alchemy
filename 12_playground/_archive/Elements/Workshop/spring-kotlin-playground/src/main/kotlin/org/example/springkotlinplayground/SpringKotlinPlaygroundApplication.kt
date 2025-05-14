package org.example.springkotlinplayground

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringKotlinPlaygroundApplication : CommandLineRunner {
	override fun run(vararg args: String?) {
		println("Hello World!")
	}
}

fun main(args: Array<String>) {
	runApplication<SpringKotlinPlaygroundApplication>(*args)
}
