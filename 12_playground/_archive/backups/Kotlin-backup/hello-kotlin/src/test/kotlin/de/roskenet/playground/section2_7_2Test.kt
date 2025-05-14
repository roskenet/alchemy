package fpinkotlin

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test

class Section272Test {
    @Test
    fun testSumOfPrimes() {
        val sumOfPrimes = sumOfPrimes(15)
        assertThat(sumOfPrimes).isEqualTo(41)
    }
}