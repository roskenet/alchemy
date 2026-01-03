package de.felixroske.kotlin.mavenkotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MavenKotlinApplication

fun main(args: Array<String>) {
	runApplication<MavenKotlinApplication>(*args)
}
