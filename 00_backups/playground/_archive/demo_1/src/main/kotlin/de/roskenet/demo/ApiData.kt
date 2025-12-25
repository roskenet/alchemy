package de.roskenet.demo

data class Artist(
    val name: String,
    val active: Boolean
)

data class Recording(
    val name: String,
    val artist: Artist,
    val year: UShort
)