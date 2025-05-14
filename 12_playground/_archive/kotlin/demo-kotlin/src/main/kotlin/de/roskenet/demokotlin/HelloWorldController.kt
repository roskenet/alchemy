package de.roskenet.demokotlin

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import other.AnotherReturn
import other.doSomething
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime

private const val EUROPE_BERLIN = "Europe/Berlin"

data class ReturnValue(
    val value: String,
    val now: ZonedDateTime,
    val simpleValue: String,
    @JsonProperty("another_sku_value")
    val anotherSKUValue: Int = 5,
    val aSuperValue: String = "a super value",
    val notNullable: Boolean = true,
    val someDouble: Double = Math.PI
)

    val artists = listOf("Amy", "Michael", "Sting")

@RestController
class HelloWorldController: HelloWorldAPI {

    @GetMapping("/other")
    override fun otherThings(): AnotherReturn {

        var x = 42L

        var y: Long = 21 * 2

        val res = x === y

        val newMap = artists.map { it.uppercase() }

        return AnotherReturn("$newMap")
    }

    @GetMapping("/hello")
    override fun helloWorld(): ReturnValue {
        return ReturnValue("Hello World", playWithJavaClasses(), "something")
    }

    private fun playWithJavaClasses(): ZonedDateTime {
        return ZonedDateTime.now(ZoneId.of(EUROPE_BERLIN))
    }
}