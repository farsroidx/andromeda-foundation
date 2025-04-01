@file:Suppress("unused")

package ir.farsroidx.m31.time

// TODO: AndromedaTimeExt ===================================================== AndromedaTimeExt ===

/**
 * Extension function to calculate the expiration date based on the current time.
 * The expiration date is calculated by adding the time duration (value * unit) to the current system time.
 * If the time object is null, it returns -1L indicating an invalid expiration date.
 *
 * @return The expiration date in milliseconds from the current time, or -1L if the time object is null.
 */
fun AndromedaTime?.newExpireTime(): Long =
    if (this != null) System.currentTimeMillis() + (this.value * this.unit.millis) else -1L

/**
 * Extension function to check if a given expiration date has passed.
 * The method checks if the expiration date is valid and if it has already passed based on the current system time.
 * If the expiration date is -1L or the current date is greater than the expiration date, it returns true (expired).
 *
 * @return True if the expiration date has passed, false otherwise.
 */
fun Long?.isTimeExpired(): Boolean =
    (this != null && this != -1L && this < System.currentTimeMillis())