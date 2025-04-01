@file:Suppress("unused")

package ir.farsroidx.m31.time

/**
 * Sealed class representing different units of time.
 * Each unit has a value representing the number of milliseconds it represents.
 *
 * The units include:
 * - Seconds
 * - Minutes
 * - Hour
 * - Day
 * - Week
 * - Month
 * - Year
 *
 * @property millis The number of milliseconds that one unit represents.
 */
sealed class AndromedaTimeUnit(val millis: Long) {

    /**
     * Represents seconds as a time unit. 1 second = 1,000 milliseconds.
     */
    data object Seconds : AndromedaTimeUnit(1_000)

    /**
     * Represents minutes as a time unit. 1 minute = 60,000 milliseconds.
     */
    data object Minutes : AndromedaTimeUnit(60_000)

    /**
     * Represents hours as a time unit. 1 hour = 3,600,000 milliseconds.
     */
    data object Hour : AndromedaTimeUnit(3_600_000)

    /**
     * Represents days as a time unit. 1 day = 86,400,000 milliseconds.
     */
    data object Day : AndromedaTimeUnit(86_400_000)

    /**
     * Represents weeks as a time unit. 1 week = 604,800,000 milliseconds.
     */
    data object Week : AndromedaTimeUnit(604_800_000)

    /**
     * Represents months as a time unit. 1 month = 18,144,000,000 milliseconds.
     */
    data object Month : AndromedaTimeUnit(18_144_000_000)

    /**
     * Represents years as a time unit. 1 year = 217,728,000,000 milliseconds.
     */
    data object Year : AndromedaTimeUnit(217_728_000_000)

}