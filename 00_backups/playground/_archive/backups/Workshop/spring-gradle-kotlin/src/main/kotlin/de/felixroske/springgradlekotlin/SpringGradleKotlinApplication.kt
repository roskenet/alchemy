package de.felixroske.springgradlekotlin

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringGradleKotlinApplication : CommandLineRunner {
	override fun run(vararg args: String?) {
		println("Hello World!")
	}
}

fun main(args: Array<String>) {
	runApplication<SpringGradleKotlinApplication>(*args)
}

fun doSomething(arg: String) : String? {
	return null
}

fun doSomething(arg: Int) : String? {
	return ""
}