package com.seedlegals.demo

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component
import java.time.Clock
import java.time.Instant

@Configuration
open class StopWatchConfiguration {
    @Bean
    open fun clock(): Clock = Clock.systemUTC()
}

@Component
class StopWatchService(private val clock: Clock) {
    private var maybeStartTime: Instant? = null
    private var maybeEndTime: Instant? = null

    fun start(): Instant {
        val now = clock.instant() // StopWatch passing control to injected clock function

        maybeStartTime = now // Store the time

        return now // Return the time
    }

    fun stop(): Instant {
        val now = clock.instant() // StopWatch passing control to injected clock function

        maybeEndTime = now // Store the time

        return now // Return the time
    }

    fun difference(): Long? =
        maybeStartTime?.let { startTime -> // if there is a value for maybeStartTime
            maybeEndTime?.let { endTime -> // if there is a value for maybeEndTime
                endTime.toEpochMilli() - startTime.toEpochMilli() // calculate difference
            }
        }

}
