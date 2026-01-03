package de.felixroske.workshop

import AnagramTester
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AnagramTest {

    @Test
    fun testAnagram_true() {
        val anagramTester = AnagramTester("Anagram")

        val result = anagramTester.isAnagramTo("Margana")

        assertThat(result).isEqualTo(true)
    }

    @Test
    fun testAnagram_false() {
        val anagramTester = AnagramTester("Blubber")

        var result = anagramTester.isAnagramTo("SomethingDifferent")

        assertThat(result).isEqualTo(false)
    }
}