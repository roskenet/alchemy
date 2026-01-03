package de.felixroske.examples.mockmvcstarter

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

//@SpringBootTest
@WebMvcTest
class MockmvcStarterApplicationTests() {

	@Autowired
	lateinit private var mockMvc: MockMvc

	@Test
	fun `Test stocks ticker endpoint`() {
		mockMvc.get("/api/stock/ME") {
			accept = MediaType.APPLICATION_JSON
		}.andExpect {
			status { isOk }
			content { string("Wirecard SE") }
		}
	}

}
