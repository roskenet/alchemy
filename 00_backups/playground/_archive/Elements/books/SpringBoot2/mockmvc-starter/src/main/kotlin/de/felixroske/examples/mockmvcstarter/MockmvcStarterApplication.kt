package de.felixroske.examples.mockmvcstarter

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class MockmvcStarterApplication

fun main(args: Array<String>) {
    runApplication<MockmvcStarterApplication>(*args)
}

@RestController
class StockController {

    @GetMapping("/api/stock/{ticker}")
    fun getStock(@PathVariable("ticker") ticker: String): String {
        return "Wirecard SE"
    }
}