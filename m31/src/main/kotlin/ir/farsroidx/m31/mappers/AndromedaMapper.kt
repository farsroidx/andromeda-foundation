@file:Suppress("unused")

package ir.farsroidx.m31.mappers

import kotlin.collections.map

/**
 * A generic abstract mapper class that facilitates conversion between two data types [L] and [R].
 * This serves as a base class for all mappers, providing transformation methods for single and list-based conversions.
 *
 * @param L The source type for mapping.
 * @param R The destination type for mapping.
 */
abstract class AndromedaMapper <L : Any, R : Any> {

    /**
     * Converts an instance of type [L] to type [R].
     *
     * @param value The source object of type [L] to be converted.
     * @return The converted object of type [R].
     */
    abstract fun toRight(value: L): R

    /**
     * Converts a list of objects of type [L] to a list of type [R].
     *
     * @param values The list of source objects to be converted.
     * @return A list of converted objects of type [R].
     */
    fun toRight(values: List<L>): List<R> = values.map { toRight(it) }

    /**
     * Converts an instance of type [R] to type [L].
     *
     * @param value The source object of type [R] to be converted.
     * @return The converted object of type [L].
     */
    abstract fun toLeft(value: R): L

    /**
     * Converts a list of objects of type [R] to a list of type [L].
     *
     * @param values The list of source objects to be converted.
     * @return A list of converted objects of type [L].
     */
    fun toLeft(values: List<R>): List<L> = values.map { toLeft(it) }

}