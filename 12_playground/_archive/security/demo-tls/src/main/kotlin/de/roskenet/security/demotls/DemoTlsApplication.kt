package de.roskenet.security.demotls

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoTlsApplication

fun main(args: Array<String>) {
    runApplication<DemoTlsApplication>(*args)
}

