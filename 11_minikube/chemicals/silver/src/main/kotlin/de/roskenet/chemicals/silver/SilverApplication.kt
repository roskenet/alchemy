package de.roskenet.chemicals.silver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@SpringBootApplication
class SilverApplication

fun main(args: Array<String>) {
    runApplication<SilverApplication>(*args)
}

data class ChemicalResponse(val message: String, val someInt: Int = 42)

@RestController
class SilverController {

    @GetMapping("/hello")
    fun hello(): ChemicalResponse {
        return ChemicalResponse("Hello World")
    }

    @GetMapping("/slow")
    fun slow(): ChemicalResponse {
        return ChemicalResponse("Slow response")
    }

    @GetMapping("/error")
    fun error(): ChemicalResponse {
        throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong")
    }
}