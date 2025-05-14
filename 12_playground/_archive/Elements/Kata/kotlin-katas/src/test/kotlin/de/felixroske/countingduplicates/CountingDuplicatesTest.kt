package de.felixroske.countingduplicates

import org.junit.Test
import kotlin.test.assertEquals

//Counting Duplicates
//
//Count the number of Duplicates
//
//Write a function that will return the count of distinct case-insensitive alphabetic characters and numeric digits that occur more than once in the input string. The input string can be assumed to contain only alphabets (both uppercase and lowercase) and numeric digits.
//Example
//
//"abcde" -> 0 # no characters repeats more than once
//"aabbcde" -> 2 # 'a' and 'b'
//"aabBcde" -> 2 # 'a' occurs twice and 'b' twice (`b` and `B`)
//"indivisibility" -> 1 # 'i' occurs six times
//"Indivisibilities" -> 2 # 'i' occurs seven times and 's' occurs twice
//"aA11" -> 2 # 'a' and '1'
//"ABBA" -> 2 # 'A' and 'B' each occur twice

class CountingDuplicatesTest {

    @Test
    fun `abcde returns zero`() {
        assertEquals(0, duplicateCount("abcde"))
    }

    @Test
    fun `abcdea returns one`() {
        assertEquals(1, duplicateCount("abcdea"))
    }

    @Test
    fun `indivisibility returns one`() {
        assertEquals(1, duplicateCount("indivisibility"))
    }

    @Test
    fun `really long string containing duplicates returns three`() {
        val text = "dA" + "c".repeat(10) + "b".repeat(100) + "a".repeat(1000)
        assertEquals(3, duplicateCount(text))
    }
}