package de.felixroske.actinium

import org.springframework.beans.factory.annotation.Value
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ArtistApi {

    @GetMapping("/artists")
    @PreAuthorize("hasAuthority('SCOPE_profile')")
    fun getArtists(): List<Artist> = listOf(
        Artist("Amy Winehouse", 1983),
        Artist("Elvis Presley", 1935)
    )

}