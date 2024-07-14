@file:Suppress("unused")

package ir.farsroidx.m31

import org.koin.core.qualifier.Qualifier
import org.koin.java.KoinJavaComponent

// TODO: AndromedaInjector =================================================== AndromedaInjector ===

inline fun <reified T> andromedaInjector(qualifier: Qualifier? = null): Lazy<T> {
    return lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        KoinJavaComponent.get(
            T::class.java, qualifier, null
        )
    }
}