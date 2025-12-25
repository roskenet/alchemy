package de.zalando.sbsproducertest

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SbsProducerTestApplication : CommandLineRunner {
    override fun run(vararg args: String?) {
        println("Hello World")
    }
}

fun main(args: Array<String>) {
    runApplication<SbsProducerTestApplication>(*args)
}
