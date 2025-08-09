package de.felixroske.clockdemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component
import java.time.Clock
import java.time.LocalDate

@SpringBootApplication
class ClockDemoApplication

fun main(args: Array<String>) {
    runApplication<ClockDemoApplication>(*args)
}

@Configuration
class ClockConfiguration {
    @Bean
    fun clock(): Clock {
        return Clock.systemDefaultZone();
    }
}

@Component
class BirthdayGreeter(val clock: Clock) {

    fun greet(user: String, birthday: LocalDate): String {
        if (LocalDate.now(clock).month == birthday.month && LocalDate.now(clock).dayOfMonth == birthday.dayOfMonth)
            return "Happy Birthday, Elvis!"
        else
            return "Hello, Elvis!"
    }

}