@file:Suppress("unused")

package ir.farsroidx.m31

import org.koin.java.KoinJavaComponent

/**
 * A singleton object serving as a central hub for all Andromeda-related functionality.
 * The object itself is extended through various extension functions to add modular capabilities.
 */
object Andromeda

/**
 * A generic function that lazily provides an instance of a given type [T] using Koin for dependency injection.
 * It is thread-safe and initializes the instance only when it's first accessed.
 *
 * @param T The type of the instance to be provided.
 * @return A lazy-initialized [T] instance, thread-safe using `LazyThreadSafetyMode.SYNCHRONIZED`.
 */
inline fun <reified T> provide(): Lazy<T> {

    return lazy(LazyThreadSafetyMode.SYNCHRONIZED) {

        // Fetch the instance of type [T] from Koin using KoinJavaComponent.
        KoinJavaComponent.get(
            T::class.java, null, null
        )
    }
}