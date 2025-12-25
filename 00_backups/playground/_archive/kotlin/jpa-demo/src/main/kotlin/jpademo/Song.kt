package jpademo

import jakarta.persistence.Entity
import jakarta.persistence.EntityListeners
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.Instant
import java.util.UUID

@Entity
@EntityListeners(AuditingEntityListener::class)
data class Song (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: UUID? = null,
    var name: String = "",

    @ManyToOne
    @JoinColumn(name= "artist_id")
    var artist: Artist? = null,

    @CreatedDate
    var createdAt: Instant? = null,
    @LastModifiedDate
    var lastModifiedAt: Instant? = null
) {
    override fun toString(): String {
        return "Song(id=$id, name='$name', createdAt=$createdAt, lastModifiedAt=$lastModifiedAt)"
    }

}
