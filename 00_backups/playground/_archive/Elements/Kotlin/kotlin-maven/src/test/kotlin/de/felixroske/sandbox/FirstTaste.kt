package de.felixroske.sandbox

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

data class Person(val name: String,
                  val age: Int? = null)

class FunWithFunctions {

    @Test
    fun `Print the oldest Person`() {
        val persons = listOf(
            Person("Alice"),
            Person("Bob", 30),
            Person("Charlie", 18)
        )

        val oldest = persons.maxBy { it.age ?: 0 }
        val first = persons.first { it.name.startsWith("c", true) }

        println("The oldest Person is: $oldest")

        assertThat(first?.name).isEqualTo("Charlie")
        assertThat(oldest?.age).isEqualTo(30)
    }
}