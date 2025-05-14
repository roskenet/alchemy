package de.zalando.mathstuff

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class KillerApp : CommandLineRunner {
    override fun run(vararg args: String?) {

        // Use the modulo operator to get the last n digits:

        val x = 22081974

        val result = x % 100

        println("The result is ${result}")
    }
}