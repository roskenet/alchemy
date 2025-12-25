package de.felixroske.kotlin

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test

class CupcakesTest {

    @Test
    fun testBlueberryCake() {
        val blueberryCupcake = BlueberryCupcake()
//        blueberryCupcake.flavour = "Chocolate"
        assertThat(blueberryCupcake.flavour).isEqualTo("Blueberry")
    }

    @Test
    fun playWithSets() {
        val mySet = setOf("A", "B", "C")

        assertThat(mySet).isEqualTo(setOf("C", "A", "B"))
    }
}
