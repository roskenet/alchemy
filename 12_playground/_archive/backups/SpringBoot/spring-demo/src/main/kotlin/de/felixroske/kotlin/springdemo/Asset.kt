package de.felixroske.kotlin.springdemo

import java.time.LocalDateTime
import java.util.UUID

class Asset(val id: UUID = UUID.randomUUID(),
                 val name: String,
                 val ticker: String,
                 val issued: LocalDateTime) {

    val eins: Int
    val zwei: Int



}

