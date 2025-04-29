package de.zalando.demo.model

/**
 * Response model for the hello endpoint.
 * @property name The name of the person
 * @property birthday The birthday of the person (empty if unknown)
 */
data class HelloResponse(
    val name: String,
    val birthday: String
)