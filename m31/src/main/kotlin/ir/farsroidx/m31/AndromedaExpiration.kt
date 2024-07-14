@file:Suppress("unused")

package ir.farsroidx.m31

import java.io.Serializable

// TODO: AndromedaExpiration =============================================== AndromedaExpiration ===

data class AndromedaExpiration(val value: Int, val unit: AndromedaTimeUnit): Serializable

// TODO: Additives =================================================================== Additives ===

fun AndromedaExpiration?.getExpDate(): Long =
    if (this != null) System.currentTimeMillis() + (this.value * this.unit.value) else -1L

fun Long?.isExpired(): Boolean =
    (this != null && this != -1L && this < System.currentTimeMillis())