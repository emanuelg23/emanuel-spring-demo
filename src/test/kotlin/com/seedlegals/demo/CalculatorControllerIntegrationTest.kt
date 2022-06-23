package com.seedlegals.demo

import org.hamcrest.CoreMatchers.containsString
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class CalculatorControllerIntegrationTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun add() {
        mockMvc
            .perform(
                get("/calculator/add")
                    .queryParam("a", "2")
                    .queryParam("b", "3")
            )
            .andExpect(status().isOk)
            .andExpect(content().string(containsString("5")))
    }

    @Test
    fun subtract() {
        mockMvc
            .perform(
                get("/calculator/subtract")
                    .queryParam("a", "8")
                    .queryParam("b", "3")
            )
            .andExpect(status().isOk)
            .andExpect(content().string(containsString("5")))
    }

    @Test
    fun multiply() {
        mockMvc
            .perform(
                get("/calculator/multiply")
                    .queryParam("a", "2")
                    .queryParam("b", "3")
            )
            .andExpect(status().isOk)
            .andExpect(content().string(containsString("6")))
    }

    @Test
    fun divide() {
        mockMvc
            .perform(
                get("/calculator/divide")
                    .queryParam("a", "18")
                    .queryParam("b", "3")
            )
            .andExpect(status().isOk)
            .andExpect(content().string(containsString("6")))
    }
}
