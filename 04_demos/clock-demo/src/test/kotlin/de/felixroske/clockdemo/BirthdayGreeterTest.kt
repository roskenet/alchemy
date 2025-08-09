package de.felixroske.clockdemo

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.Clock
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId

class BirthdayGreeterTest {

    @Test
    fun testBirthday_True() {
        val clock = Clock.fixed(Instant.parse("2025-01-08T10:00:00.00Z"), ZoneId.of("Europe/Berlin"))
        val greeter = BirthdayGreeter(clock)

        val result = greeter.greet("Elvis", LocalDate.of(1935, 1, 8))

        assertThat(result).isEqualTo("Happy Birthday, Elvis!")
    }

    @Test
    fun testBirthday_False() {
        val clock = Clock.fixed(Instant.parse("2025-01-08T23:00:00.00Z"), ZoneId.of("Europe/Berlin"))
        val greeter = BirthdayGreeter(clock)

        val result = greeter.greet("Elvis", LocalDate.of(1935, 1, 8))

        assertThat(result).isEqualTo("Hello, Elvis!")
    }
}