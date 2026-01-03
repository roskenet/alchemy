package de.felixroske.listofallrationals

import kotlin.test.assertEquals
import org.junit.Test

class TestKata {
    private val a = allRationals().asSequence().take(100001).toList()

    @Test
    fun simpleTests() {
        assertEquals(Pair(1, 1), a[0])
        assertEquals(Pair(1, 3), a[3])
        assertEquals(Pair(3, 2), a[4])
        assertEquals(Pair(5, 2), a[10])
    }

    @Test
    fun largerIndices() {
        assertEquals(Pair(19, 12), a[100])
        assertEquals(Pair(39, 28), a[1000])
        assertEquals(Pair(205, 162), a[10000])
        assertEquals(Pair(713, 586), a[100000])
    }
}