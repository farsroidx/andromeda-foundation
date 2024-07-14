@file:Suppress("unused")

package ir.farsroidx.m31

import org.koin.java.KoinJavaComponent

// TODO: AndromedaInjector =================================================== AndromedaInjector ===

inline fun <reified T> andromedaInjector(): Lazy<T> {
    return lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        KoinJavaComponent.get(
            T::class.java, null, null
        )
    }
}