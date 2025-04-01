@file:Suppress("unused", "unused")

package ir.farsroidx.m31.result

/**
 * A sealed interface representing the result of an operation,
 * which can either be a success or a failure.
 */
sealed interface AndromedaResult <out T> {

    /**
     * Data class representing a successful result containing the data of type T.
     * */
    data class Success <out T> (val data: T): AndromedaResult<T>

    /**
     * Data class representing a failed result containing an error of type AndromedaResultError.
     * */
    data class Failure <out T> (val error: AndromedaResultError): AndromedaResult<T>

}

