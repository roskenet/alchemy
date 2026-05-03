package springrestservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

data class Artist(val name: String, val genre: String)

@RestController
class ArtistController {
   @GetMapping("/artists")
   fun getArtists(): List<Artist> = listOf(
       Artist("Metallica", "Rock"),
       Artist("Pink Floyd", "Rock"),
       Artist("Led Zeppelin", "Rock"))
}

@SpringBootApplication
class SpringRestServiceApplication

fun main(args: Array<String>) {
    runApplication<SpringRestServiceApplication>(*args)
}
