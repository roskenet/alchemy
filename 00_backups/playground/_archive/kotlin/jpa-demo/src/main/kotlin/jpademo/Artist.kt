package jpademo

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.EntityListeners
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.Instant
import java.util.UUID

@Entity
@EntityListeners(AuditingEntityListener::class)
data class Artist (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: UUID? = null,
    var name: String = "",

    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "artist")
    var songs: MutableList<Song> = mutableListOf(),

    @CreatedDate
    var createdAt: Instant? = null,
    @LastModifiedDate
    var lastModifiedAt: Instant? = null
) {
    fun addSong(song: Song) {
        song.artist = this
        this.songs.add(song)
    }
}