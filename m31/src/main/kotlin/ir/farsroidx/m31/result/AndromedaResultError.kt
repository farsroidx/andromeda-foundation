@file:Suppress("unused")

package ir.farsroidx.m31.result

/**
 * Interface representing the error associated with a failure in the result.
 * */
interface AndromedaResultError {

    /**
     * Data class to wrap a Throwable exception.
     * This can be used to wrap any exception that occurs during execution,
     * like network timeouts, IO exceptions, etc.
     * This is useful for capturing the full exception stack trace.
     */
    data class Throwable(val throwable: kotlin.Throwable): AndromedaResultError

}