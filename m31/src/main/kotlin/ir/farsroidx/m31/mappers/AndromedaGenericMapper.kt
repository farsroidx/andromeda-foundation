@file:Suppress("unused", "UNCHECKED_CAST")

package ir.farsroidx.m31.mappers

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.lang.reflect.ParameterizedType

class AndromedaGenericMapper <L : Any, R : Any> : AndromedaMapper<L, R>() {

    private val gson: Gson = GsonBuilder()
        // Keep field naming consistent (Identity)
        .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
        .create()

    /**
     * Lazily retrieves the Class type for the left type (L).
     */
    private val typeL by lazy { genericType<L>(0) }

    /**
     * Lazily retrieves the Class type for the right type (R).
     */
    private val typeR by lazy { genericType<R>(1) }

    /**
     * Converts a value of type L to type R using Gson.
     * @param value The value of type L.
     * @return The converted value of type R.
     */
    override fun toRight(value: L): R {
        return gson.fromJson(gson.toJson(value, typeL), typeR)
    }

    /**
     * Converts a value of type R to type L using Gson.
     * @param value The value of type R.
     * @return The converted value of type L.
     */
    override fun toLeft(value: R): L {
        return gson.fromJson(gson.toJson(value, typeR), typeL)
    }

    /**
     * Retrieves the generic type at a given index (0 for L, 1 for R).
     * This function uses reflection to get the actual type arguments of the class.
     * @param index The index of the generic type (0 for L, 1 for R).
     * @return The Class type corresponding to the provided index.
     */
    private fun <T : Any> genericType(index: Int): Class<T> {
        return (this::class.java.genericSuperclass as ParameterizedType)
            .actualTypeArguments[index] as Class<T>
    }
}