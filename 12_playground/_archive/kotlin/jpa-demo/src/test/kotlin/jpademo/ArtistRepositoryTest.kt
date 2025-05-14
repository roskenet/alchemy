package jpademo

import jakarta.transaction.Transactional
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ArtistRepositoryTest {

    @Autowired
    lateinit var artistRepository: ArtistRepository

    @Test
    @Transactional
    fun test001InsertArtist() {
        // Let's save Michael:
        val michaelJackson = Artist(name = "Michael Jackson")
        artistRepository.save(michaelJackson)

        // We get all artists:
        val allArtists = artistRepository.findAll()

        // There should only be one:
        assertThat(allArtists.count()).isEqualTo(1)
    }

    @Test
    @Transactional
    fun test002InsertArtist() {
        val inxs = Artist(name = "INXS")
        val suicideBlonde = Song(name = "Suicide Blonde")

        inxs.addSong(suicideBlonde)

        artistRepository.save(inxs)

        val findAll = artistRepository.findAll()

        val savedArtist = findAll.first()
        assertThat(savedArtist.songs).hasSize(1)
        assertThat(savedArtist.songs[0].name).isEqualTo("Suicide Blonde")
    }
}