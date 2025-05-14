package de.roskenet.aluminium

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.CommandLineRunner


@SpringBootApplication
class KotlinDemoApp : CommandLineRunner {

}

fun main(args: Array<String>) {
    runApplication<KotlinDemoApp>(*args)
}