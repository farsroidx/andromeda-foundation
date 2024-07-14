@file:Suppress("unused")

package ir.farsroidx.m31

sealed class AndromedaTimeUnit(val value: Long = 0) {
    data object Seconds : AndromedaTimeUnit(1_000)
    data object Minutes : AndromedaTimeUnit(60_000)
    data object Hour    : AndromedaTimeUnit(3_600_00)
    data object Day     : AndromedaTimeUnit(86_400_000)
    data object Week    : AndromedaTimeUnit(604_800_000)
    data object Month   : AndromedaTimeUnit(18_144_000_000)
    data object Year    : AndromedaTimeUnit(217_728_000_000)
}