package de.felixroske.hellospring

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ScientistApi {
    @GetMapping("/scientists")
    fun getScientists(): List<Scientist> {
        return emptyList()
    }
}