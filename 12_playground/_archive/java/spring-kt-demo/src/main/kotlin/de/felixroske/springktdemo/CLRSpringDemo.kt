package de.felixroske.springktdemo

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

fun doSomething(name: String): String {
   return "Hallo ${name.uppercase()}!"
}

@Component
class CLRSpringDemo : CommandLineRunner {
    override fun run(vararg args: String?) {
        println(doSomething("Felix"))
    }
}