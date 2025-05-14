import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ApplicationTest {

    @Test
    fun doSomethingBeautiful() {
        assertThat(true).isEqualTo(true)
    }

    @Test
    fun testCoroutines() {

        var x = 0
        var y = 1

        GlobalScope.launch {
            delay(1000)
            println("World!")
            x = 1
        }

        println("Hello")
        Thread.sleep(4000)
//        while (x == 0) {
//            y++
//        }
    }
}