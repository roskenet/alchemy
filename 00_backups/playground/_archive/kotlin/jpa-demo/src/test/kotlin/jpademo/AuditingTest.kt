package jpademo

import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class AuditingTest {

    @Autowired
    lateinit var artistRepository: ArtistRepository

    @Test
    fun auditingTest(){
        val inxs = Artist(name = "INXS")
        val suicideBlonde = Song(name = "Suicide Blonde")

        inxs.addSong(suicideBlonde)

        artistRepository.save(inxs)

        val artist = artistRepository.findByName("INXS")

        artist?.let {
            artist.name = "INXS changed"
            Thread.sleep(5000)
            artistRepository.save(artist)
        }

        val updatedArtist: Artist? = artistRepository.findByName("INXS changed")
        assertNotNull(updatedArtist)

    }
}