package de.felixroske

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

enum class Element(val protonNumber: Int, val symbol: String) {
    Hydrogen(1, "H"),
    Helium(2, "He"),
    Lithium(3, "Li"),
    Beryllium(4, "Be")
}


class HelloTest {

    @Test
    fun `Spaß mit Arrays`() {

        val elements = arrayOf("oxygen", "carbon", "helium").sortedArray()
        elements.forEach(::println)

        assertThat(true).isEqualTo(true)
    }
}
