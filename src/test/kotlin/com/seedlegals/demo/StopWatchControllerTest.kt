package com.seedlegals.demo

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.hamcrest.CoreMatchers.containsString
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.time.Instant

@WebMvcTest(StopWatchController::class)
class StopWatchControllerTest {

    @TestConfiguration
    open class StopWatchControllerTestConfig {

        @Bean
        open fun stopWatchService() = mockk<StopWatchService>().apply {
            every { start() } returns Instant.MIN
            every { stop() } returns Instant.MIN.plusSeconds(1)
            every { difference() } returns 1
        }
    }

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var mockStopWatchService: StopWatchService

    @Test
    fun start() {
        mockMvc
            .perform(
                get("/stopwatch/run")
            )
            .andExpect(status().isOk)
            .andExpect(content().string(containsString("1")))

        verify { mockStopWatchService.start() }
    }
}
