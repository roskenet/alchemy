package jpademo

import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface ArtistRepository: CrudRepository<Artist, UUID> {
    fun findByName(name: String): Artist?
}
