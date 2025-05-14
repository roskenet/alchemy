package de.felixroske.webserverstest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WebserversTestApplication

fun main(args: Array<String>) {
    runApplication<WebserversTestApplication>(*args)
}
