package de.zalando.demo.controller

import de.zalando.demo.model.HelloResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate
import java.time.format.DateTimeFormatter

/**
 * Controller for handling hello requests.
 */
@RestController
class HelloController {

    companion object {
        private const val ELVIS_FULL_NAME = "Elvis A. Presley"
        private val ELVIS_BIRTHDAY = LocalDate.of(1935, 1, 8)
        private val DATE_FORMATTER = DateTimeFormatter.ISO_DATE
    }

    /**
     * Endpoint to greet a person by name.
     * If the name is "Elvis", returns Elvis Presley's information.
     * Otherwise, returns "UNKNOWN" with an empty birthday.
     *
     * @param name The name of the person to greet
     * @return A HelloResponse containing the person's name and birthday
     */
    @GetMapping("/hello/{name}")
    fun greetPerson(@PathVariable name: String): HelloResponse {
        return if (name.equals("Elvis", ignoreCase = true)) {
            HelloResponse(
                name = ELVIS_FULL_NAME,
                birthday = ELVIS_BIRTHDAY.format(DATE_FORMATTER)
            )
        } else {
            HelloResponse(
                name = "UNKNOWN",
                birthday = ""
            )
        }
    }
}