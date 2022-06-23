package com.seedlegals.demo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("calculator")
class CalculatorController(
    private val calculatorService: CalculatorService
) {

    @GetMapping("/add")
    fun add(
        @RequestParam a: Int,
        @RequestParam b: Int
    ): Int = calculatorService.add(a, b)

    @GetMapping("/subtract")
    fun subtract(
        @RequestParam a: Int,
        @RequestParam b: Int
    ): Int = calculatorService.subtract(a, b)

    @GetMapping("/multiply")
    fun multiply(
        @RequestParam a: Int,
        @RequestParam b: Int
    ): Int = calculatorService.multiply(a, b)

    @GetMapping("/divide")
    fun divide(
        @RequestParam a: Int,
        @RequestParam b: Int
    ): Float = calculatorService.divide(a.toFloat(), b.toFloat())
}
