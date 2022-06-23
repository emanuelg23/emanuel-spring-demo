package com.seedlegals.demo

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CalculatorServiceTest {
    private lateinit var unit: CalculatorService

    @BeforeEach
    fun setup() {
        unit = CalculatorService()
    }

    @Test
    fun `add two numbers`() {
        val result = unit.add(1, 2)

        assertEquals(3, result)
    }

    @Test
    fun `subtract two numbers`() {
        val result = unit.subtract(10, 4)

        assertEquals(6, result)
    }

    @Test
    fun `multiply two numbers`() {
        val result = unit.multiply(2, 3)

        assertEquals(6, result)
    }

    @Test
    fun `divide two integers`() {
        val result = unit.divide(1f, 2f)
        assertEquals(0.5f, result)
    }
}
