package de.zalando.vanilla

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class VanillaAppApplicationTests {

    @Autowired
    lateinit var theSinger: Singer

    @Test
    fun testSinger() {
        val song = theSinger.sing()

        assertThat(song).isEqualTo("La, la, la!")
    }
}
