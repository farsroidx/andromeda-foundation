@file:Suppress("unused")

package ir.farsroidx.m31

import org.koin.core.module.Module

/**
 * Interface for providers that need to initialize Koin modules.
 * Classes implementing this interface must define their Koin module initialization in the [initKoinModule] method.
 */
interface AndromedaProvider {

    /**
     * Initializes and returns the Koin module that defines the dependency injection setup for this provider.
     * The module should be defined here for any necessary initialization.
     *
     * @return The [Module] that configures dependencies.
     */
    fun initKoinModule(): Module

}