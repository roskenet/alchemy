package de.roskenet

import java.util.UUID

@JvmInline
value class ArtistId(val id: String)

fun ArtistId.genId(): UUID {
    return UUID.randomUUID()
}