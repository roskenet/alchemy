package de.zalando.demo.operatonserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class OperatonServerApplication

fun main(args: Array<String>) {
    runApplication<OperatonServerApplication>(*args)
}
