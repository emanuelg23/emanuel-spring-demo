package com.seedlegals.demo

import org.springframework.stereotype.Component

@Component
class CalculatorService {
    fun add(a: Int, b: Int): Int {
        return a + b
    }

    fun subtract(a: Int, b: Int): Int {
        return a - b
    }

    fun multiply(a: Int, b: Int): Int {
        return a * b
    }

    fun divide(a: Float, b: Float): Float {
        return (a / b)
    }

}
