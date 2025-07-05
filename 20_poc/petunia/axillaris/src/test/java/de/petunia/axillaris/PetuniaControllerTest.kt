package de.petunia.axillaris

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@WebMvcTest(PetuniaController::class)
class PetuniaControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @Test
    fun testGetPetunia() {
        // Expected Petunia object from the controller
        val expectedPetunia = Petunia("Rosa", 4)

        mockMvc.perform(get("/petunias"))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.species").value(expectedPetunia.species))
            .andExpect(jsonPath("$.petal_length").value(expectedPetunia.petalLength))
    }

    @Test
    fun testPostPetunia() {
        // Create a test Petunia object
        val testPetunia = Petunia("Violacea", 6)
        val petuniaJson = objectMapper.writeValueAsString(testPetunia)

        mockMvc.perform(post("/petunias")
            .contentType(MediaType.APPLICATION_JSON)
            .content(petuniaJson))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.species").value("Violacea"))
            .andExpect(jsonPath("$.petal_length").value(6))
    }
}