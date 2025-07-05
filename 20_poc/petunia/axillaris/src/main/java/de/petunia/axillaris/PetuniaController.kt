package de.petunia.axillaris

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/petunias")
open class PetuniaController {

    @GetMapping
    fun getPetunia() : Petunia {
        return Petunia("Rosa", 4)
    }

    @PostMapping
    fun postPetunia(@RequestBody petunia: Petunia) : Petunia {
        println(petunia)
        return petunia
    }
}
