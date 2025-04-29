package de.zalando.demo.controller

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@WebMvcTest(HelloController::class)
class HelloControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun `should return Elvis information when name is Elvis`() {
        mockMvc.perform(get("/hello/Elvis")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.name").value("Elvis A. Presley"))
            .andExpect(jsonPath("$.birthday").value("1935-01-08"))
    }

    @Test
    fun `should return UNKNOWN when name is not Elvis`() {
        mockMvc.perform(get("/hello/John")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.name").value("UNKNOWN"))
            .andExpect(jsonPath("$.birthday").value(""))
    }

    @Test
    fun `should be case insensitive for Elvis name`() {
        mockMvc.perform(get("/hello/elvis")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.name").value("Elvis A. Presley"))
            .andExpect(jsonPath("$.birthday").value("1935-01-08"))
    }
}