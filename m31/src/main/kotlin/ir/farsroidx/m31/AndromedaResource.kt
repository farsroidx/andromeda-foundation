@file:Suppress("unused")

package ir.farsroidx.m31

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.first

// TODO: AndromedaResource =================================================== AndromedaResource ===

sealed class AndromedaResource<T> {

    data class Success<M>(val data: M) : AndromedaResource<M>()

    data class Failure<M>(val throwable: Throwable) : AndromedaResource<M>()

}

// TODO: Resource ===================================================================== Resource ===

suspend fun <T> Flow<AndromedaResource<T>>.collectResource(
    onFailure   : suspend (Throwable) -> Unit = {},
    onValidation: suspend (Boolean)   -> Unit = {},
    onSuccess   : suspend (T)         -> Unit = {},
) {
    this.first()
        .onFailure    { onFailure(it)    }
        .onValidation { onValidation(it) }
        .onSuccess    { onSuccess(it)    }
}

suspend fun <T> AndromedaResource<T>.onSuccess(
    callback: suspend (T) -> Unit
): AndromedaResource<T> {
    if (this is AndromedaResource.Success) callback(this.data)
    return this
}

suspend fun <T> AndromedaResource<T>.onFailure(
    callback: suspend (Throwable) -> Unit
): AndromedaResource<T> {
    if (this is AndromedaResource.Failure) callback(this.throwable)
    return this
}

suspend fun <T> AndromedaResource<T>.onValidation(
    callback: suspend (Boolean) -> Unit
): AndromedaResource<T> {
    callback(this is AndromedaResource.Success)
    return this
}

suspend fun <T: Any?> FlowCollector<AndromedaResource<T>>.emitResource(invoke: suspend () -> T) {
    emit( andromedaResource( invoke ) )
}

suspend fun <T: Any?> andromedaResource(invoke: suspend () -> T): AndromedaResource<T> {
    return try {
        AndromedaResource.Success( invoke() )
    } catch (throwable: Throwable) {
        AndromedaResource.Failure( throwable )
    }
}