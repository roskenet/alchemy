package kata.flxkata

import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test


// Johnson-Steinhaus-Trotter

fun permutations(arg: List<String>): List<String> {
    return emptyList()
}

class JSTTest {

    @Test
    fun testABC() {
        val objects = listOf("A", "B", "C")
        assertThat(objects).isEqualTo(listOf<String>(
            "ABC", "BAC", "BCA", "ACB", "CAB", "CBA"
        ))
    }
}
