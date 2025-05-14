package de.zalando.vanilla

import org.springframework.stereotype.Component

@Component
class Singer {
    fun sing(): String {
        return "La, la, la!"
    }
}