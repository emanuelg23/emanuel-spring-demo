package com.seedlegals.demo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("stopwatch")
class StopWatchController(
    private val stopWatchService: StopWatchService
) {

    @GetMapping("/run")
    fun run(): Long? {
        stopWatchService.start()
        Thread.sleep(1000)
        stopWatchService.stop()
        return stopWatchService.difference()
    }

    @GetMapping("/start")
    fun start(): Long = stopWatchService.start().toEpochMilli()

    @GetMapping("/stop")
    fun stop(): Long = stopWatchService.stop().toEpochMilli()

    @GetMapping("/difference")
    fun difference(): Long? = stopWatchService.difference()

}
