package de.felixroske.kotlin.mavenkotlin

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

//@SpringBootTest
class MavenKotlinApplicationTests {

	@Test
	fun contextLoads() {
		val myVal = true

		var myResult = when {
			myVal -> "IsTrue"
			else -> "IsNotTrue"
		}

        assertThat(myResult).isEqualTo("IsTrue")
	}

}
