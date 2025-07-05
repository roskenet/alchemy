package de.petunia.axillaris

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class PetuniaController {

    @GetMapping("/petunias")
    fun getPetunia() : Petunia {
        return Petunia("Rosa", 4)
    }

    @PostMapping("/petunias")
    fun postPetunia(@RequestBody petunia: Petunia) : Petunia {
        println(petunia)
        return petunia
    }
}
