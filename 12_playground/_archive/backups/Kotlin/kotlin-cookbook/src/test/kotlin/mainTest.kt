import org.junit.jupiter.api.Test
import org.hamcrest.Matchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.DisplayName

class MainTest {

    @Test
    @DisplayName("We can destructure a Pair")
    fun `destructuring a Pair`() {
        val pair = "a" to 0
        val (x, y) = pair

//        println("I am doing something useful")

        assertThat(x, `is`("a"))
        assertThat(y, `is`(0))
    }

}