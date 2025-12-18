package de.roskenet.iron

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

data class Artist(val name: String, val genre: String)

@RestController
class ArtistController {

    @GetMapping("/api/artists")
    fun getArtists(): List<Artist> = listOf(
        Artist(name = "Elvis Presley", genre = "Rock'n'roll"),
        Artist(name = "Amy Winehouse", genre = "Soul")
    )
}