package helloworld;

import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

fun helloWorld() = "Hello World!"

class HelloWorldTest {
    @Test
    fun testHelloWorld() {
        helloWorld()
        assertThat(helloWorld()).isEqualTo("Hello World!")
    }
}