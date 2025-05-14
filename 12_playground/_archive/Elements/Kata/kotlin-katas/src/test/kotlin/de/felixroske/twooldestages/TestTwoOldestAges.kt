package de.felixroske.twooldestages

import junit.framework.Assert.assertEquals
import org.junit.Test

class TestTwoOldestAges {
   @Test
   fun testTwoOldestAges() {
//      twoOldestAges(listOf(1,5,87,45,8,8)) shouldBe listOf(45, 87)
       assertEquals(twoOldestAges(listOf(1,5,87,45,8,8)), listOf(45, 87))
   }
}
