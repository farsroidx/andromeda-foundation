@file:Suppress("unused")

package ir.farsroidx.m31.result

// TODO: AndromedaResultExt ================================================= AndromedaResultExt ===

/**
 * This function can be used for handling success cases with the result type.
 * It allows the caller to handle the result when it is successful.
 *
 * @param callback The callback that will be executed if the result is a success.
 * @return The current result object for chaining further operations.
 */
suspend fun <T> AndromedaResult<T>.onSuccess(
    callback: suspend (T) -> Unit
): AndromedaResult<T> {
    // If the result is a Success, execute the callback with the data.
    if (this is AndromedaResult.Success) callback(this.data)
    return this
}

/**
 * This function can be used for handling failure cases with the error type.
 * It allows the caller to handle specific error types when a failure occurs.
 *
 * @param callback The callback that will be executed if the result is a failure.
 * @return The current result object for chaining further operations.
 */
suspend fun <T> AndromedaResult<T>.onFailure(
    callback: suspend (AndromedaResultError) -> Unit
): AndromedaResult<T> {
    // If the result is a Failure, execute the callback with the error data.
    if (this is AndromedaResult.Failure) callback(this.error)
    return this
}

/**
 * Helper function to retrieve the data from a successful result.
 * If the result is not a Success, it will return null.
 *
 * @return The data from the result, or null if it's not a success.
 */
fun <T> AndromedaResult<T>.success(): T? =
    if (this is AndromedaResult.Success) this.data else null

/**
 * Helper function to retrieve the error from a failed result.
 * If the result is not a Failure, it will return null.
 *
 * @return The error from the result, or null if it's not a failure.
 */
fun <T> AndromedaResult<T>.failure(): AndromedaResultError? =
    if (this is AndromedaResult.Failure) this.error else null